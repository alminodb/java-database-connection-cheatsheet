package com.predispit.pripremapredispit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent formRoot = FXMLLoader.load(getClass().getResource("form.fxml"));
        Scene formScene = new Scene(formRoot);
        primaryStage.setScene(formScene);
        primaryStage.setTitle("Data Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        // Close the database connection when the application is closed
        Database.closeConnection();
        super.stop();
    }
}
