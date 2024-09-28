package com.predispit.pripremapredispit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nazivField;
    @FXML
    private TextField kolicinaField;
    @FXML
    private DatePicker datumPicker;
    @FXML
    private ComboBox<String> vrstaComboBox;

    @FXML
    private void initialize() {
        vrstaComboBox.getItems().addAll("ledeno", "suho", "frisko");
    }

    @FXML
    private void addData(ActionEvent event) {
        try {
            String query = "INSERT INTO " + Database.TABLE + " (idArtikal, naziv, kolicina, datumIsteka, vrsta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, idField.getText());
            preparedStatement.setString(2, nazivField.getText());
            preparedStatement.setString(3, kolicinaField.getText());
            preparedStatement.setString(4, datumPicker.getValue().toString());
            preparedStatement.setString(5, vrstaComboBox.getValue());

            preparedStatement.executeUpdate();

            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openTableWindow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Data Table");

            // Load data into the table in the TableController
            TableController tableController = loader.getController();
            tableController.loadData();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchForArticles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search-table.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Search table");

            // Load data into the table in the TableController
            TableController tableController = loader.getController();
            tableController.loadData();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        idField.clear();
        nazivField.clear();
        kolicinaField.clear();
        datumPicker.getEditor().clear();
        vrstaComboBox.setValue(null);
    }
}
