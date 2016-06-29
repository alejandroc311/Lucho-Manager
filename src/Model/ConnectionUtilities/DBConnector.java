package Model.ConnectionUtilities;
import Model.Account;
import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Alejandro on 6/10/2016.
 */
//this class will deal with everything that has to do with accessing the database and manipulating it..
public class DBConnector {
    //this class needs a connection which it will obtain from the declared connection pool.
    private Connection mConnection = null;
    private ConnectionPool mConnectionPool = new ConnectionPool();
    public DBConnector(){}

    //this method will set the connection to be equal to a connection from the connection pool.
    public void setConnection(){
        try{
            //the single connection will equal a random connection from the connection pool
            mConnection = mConnectionPool.getConnection();
            System.out.println("Connection was grabbed from pool.");
        }
        catch(SQLException e){
            throw new IllegalStateException("cannot connect",e);
        }
    }
    //this method returns the original connection member field.
    //if the connection is null, it means the connection member field is has not been linked to a connection from
    //the connection pool and it must be set up. Or if the connection was closed.
    public Connection getConnection() throws SQLException {
        if(mConnection==null||mConnection.isClosed()){
            setConnection();
        }
        return mConnection;
    }


    // method for inserting data of account information into database
    public void insertDataToAccountTable(Account account) throws SQLException {
        String insertStatement = "INSERT INTO account (accountOwner, moneyInvested, moneyWonOrLost,accountNumber,dateCreated, dateClosed)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertStatement);
        preparedStatement.setString(1,account.getAccountOwner()); preparedStatement.setDouble(2,account.getMoneyInvested());
        preparedStatement.setDouble(3,account.getMoneyWonOrLost()); preparedStatement.setInt(4,account.getAccountNumber());
        preparedStatement.setDate(5,account.getDateCreatedSQL());preparedStatement.setDate(6,null);
        preparedStatement.execute();
        getConnection().close();
    }
    //method for editing and updating information in database
    public void editDataInAccountTable(Account account) throws SQLException{
        String editStatement = "UPDATE account SET moneyInvested = ? WHERE accountNumber = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(editStatement);
        preparedStatement.setDouble(1,account.getMoneyInvested()); preparedStatement.setInt(2,account.getAccountNumber());
        preparedStatement.executeUpdate();
        getConnection().close();

    }
    //method for deleting accounts from the database
    public void removeDataInAccountTable(Account account)throws SQLException{
        String deleteStatement = "DELETE FROM account WHERE accountNumber = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleteStatement);
        preparedStatement.setInt(1,account.getAccountNumber());
        preparedStatement.execute();
        getConnection().close();
    }

    public void selectDataInAccountTable(Account account)throws SQLException{
        String selectStatement = "SELECT accountNumber,accountOwner FROM account WHERE accountNumber = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(selectStatement);
        preparedStatement.setInt(1,account.getAccountNumber());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println("Deleted account #:" +resultSet.getInt("accountNumber")+
                    "\nOwner:"+resultSet.getString("accountOwner"));
        }
        getConnection().close();

    }


}










