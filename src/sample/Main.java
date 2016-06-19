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

        account.setAccountOwner("Alejandro"); account.setMoneyInvested(771.00); account.setMoneyWonOrLost(75.00);
        account.setAccountNumber(1000);
        dbConnector.insertDataToAccountTable(account);
    }

}
