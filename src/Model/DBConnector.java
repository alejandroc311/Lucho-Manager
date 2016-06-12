package Model;

import sun.rmi.runtime.Log;

import java.io.Console;
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
    public DBConnector(){}

    public Connection getConnection(){
        try ( Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected successfully");
            return connection;
        }catch(SQLException e){
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    public void insertDataToDB(Account account) throws SQLException {
        String accountQuery = "INSERT INTO account (accountOwner, moneyInvested, moneyWonOrLost,accountNumber,dateCreated, dateClosed)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(accountQuery);
        preparedStatement.setString(1,account.getAccountOwner()); preparedStatement.setDouble(2,account.getMoneyInvested());
        preparedStatement.setDouble(3,account.getMoneyWonOrLost()); preparedStatement.setDate(4,account.getDateCreatedSQL());
        preparedStatement.setDate(5,null);
    }
}
