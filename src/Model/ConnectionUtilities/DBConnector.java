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
public class DBConnector {

    private String url = "jdbc:mysql://localhost:3306/javabase?&useSSL=false";
    private String username = "java";
    private String password = "Gohanssj2";
    private Connection mConnection = null;
    private ConnectionPool mConnectionPool;
    public DBConnector(){}


    public void setConnection(){
        try{
            mConnection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection was created.");
        }
        catch(SQLException e){
            throw new IllegalStateException("cannot connect",e);
        }
    }

    public Connection getConnection(){
        if(mConnection==null){
            setConnection();
        }
        return mConnection;
    }



    public void insertDataToAccountTable(Account account) throws SQLException {
        String accountQuery = "INSERT INTO account (accountOwner, moneyInvested, moneyWonOrLost,accountNumber,dateCreated, dateClosed)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(accountQuery);
        preparedStatement.setString(1,account.getAccountOwner()); preparedStatement.setDouble(2,account.getMoneyInvested());
        preparedStatement.setDouble(3,account.getMoneyWonOrLost()); preparedStatement.setInt(4,account.getAccountNumber());
        preparedStatement.setDate(5,account.getDateCreatedSQL());preparedStatement.setDate(6,null);
        preparedStatement.execute();
        getConnection().close();
    }
}
