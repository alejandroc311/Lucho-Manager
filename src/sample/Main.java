package sample;

import Model.Account;
import Model.ConnectionUtilities.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    private static DBConnector dbConnector = new DBConnector();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        launch(args);
        Account account = new Account();
        System.out.println("Connecting database...");

        account.setAccountOwner("Lucho"); account.setMoneyInvested(0.00); account.setMoneyWonOrLost(0.00);
        account.setAccountNumber(1000);
        System.out.println("Account created.");
        dbConnector.insertDataToAccountTable(account);
        System.out.println("Accont sent to database.");
        account.setMoneyInvested(791.00); account.setMoneyWonOrLost(75.00);
        System.out.println("Account edited.");
        dbConnector.editDataInAccountTable(account);
        System.out.println("Edited account sent to database.");
        dbConnector.selectDataInAccountTable(account);
        dbConnector.removeDataInAccountTable(account);
        System.out.println("Deleted data from database.");
    }

}
