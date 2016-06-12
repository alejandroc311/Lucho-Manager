package Model;

import sun.rmi.runtime.Log;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alejandro on 6/10/2016.
 */
public class DBConnector {

    private String url = "jdbc:mysql://localhost:3306/javabase?&useSSL=false";
    private String username = "java";
    private String password = "Gohanssj2";
    public DBConnector(){}
    public void connectToDB(){
        try ( Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connected successfully");

        }catch(SQLException e){
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    private void insertDataToDB(Account account){
        String accountQuery = "INSERT INTO account (accountOwner, moneyInvested, moneyWonOrLost,accountNumber,dateCreated, dateClosed)" +
                "VALUES (?,?,?,?,?,?)";


    }
}
