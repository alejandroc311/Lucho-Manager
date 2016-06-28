package Model.ConnectionUtilities;
import Model.Account;
import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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



    public void insertDataToAccountTable(Account account) throws SQLException {
        String insertQuery = "INSERT INTO account (accountOwner, moneyInvested, moneyWonOrLost,accountNumber,dateCreated, dateClosed)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery);
        preparedStatement.setString(1,account.getAccountOwner()); preparedStatement.setDouble(2,account.getMoneyInvested());
        preparedStatement.setDouble(3,account.getMoneyWonOrLost()); preparedStatement.setInt(4,account.getAccountNumber());
        preparedStatement.setDate(5,account.getDateCreatedSQL());preparedStatement.setDate(6,null);
        preparedStatement.execute();
        getConnection().close();
    }
    public void editDataInAccountTable(Account account) throws SQLException{
        String editQuery = "UPDATE account SET moneyInvested = ? where accountNumber = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(editQuery);
        preparedStatement.setDouble(1,account.getMoneyInvested()); preparedStatement.setInt(2,account.getAccountNumber());
        preparedStatement.executeUpdate();
        getConnection().close();

    }


}
