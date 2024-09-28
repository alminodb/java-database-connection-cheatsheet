package com.predispit.pripremapredispit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.predispit.pripremapredispit.Database.*;
import javafx.scene.control.TextField;

public class TableController {
    @FXML
    private TableView<DataModel> tableView;
    @FXML
    private TableColumn<DataModel, String> idColumn;
    @FXML
    private TableColumn<DataModel, String> nazivColumn;
    @FXML
    private TableColumn<DataModel, String> kolicinaColumn;
    @FXML
    private TableColumn<DataModel, String> datumColumn;
    @FXML
    private TableColumn<DataModel, String> vrstaColumn;
    @FXML
    private TextField searchField;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nazivColumn.setCellValueFactory(cellData -> cellData.getValue().nazivProperty());
        kolicinaColumn.setCellValueFactory(cellData -> cellData.getValue().kolicinaProperty());
        datumColumn.setCellValueFactory(cellData -> cellData.getValue().datumProperty());
        vrstaColumn.setCellValueFactory(cellData -> cellData.getValue().vrstaProperty());

        // Load data into the table
        loadData();
    }

    public void loadData() {
        try {
            String query = "SELECT * FROM "+Database.TABLE;
            ResultSet resultSet = Database.executeQuery(query);

            tableView.getItems().clear();
            while (resultSet.next()) {
                tableView.getItems().add(new DataModel(
                        resultSet.getString("idArtikal"),
                        resultSet.getString("naziv"),
                        resultSet.getString("kolicina"),
                        resultSet.getString("datumIsteka"),
                        resultSet.getString("vrsta")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void articleSearch(ActionEvent actionEvent) {
        try {
            String query = "";
            if(searchField.getText().length() > 0) {
                query = "SELECT * FROM " + Database.TABLE + " WHERE naziv LIKE '%" + searchField.getText() + "%'";
            }
            else {
                query = "SELECT * FROM " + Database.TABLE;
            }
            ResultSet resultSet = Database.executeQuery(query);

            tableView.getItems().clear();
            while (resultSet.next()) {
                tableView.getItems().add(new DataModel(
                        resultSet.getString("idArtikal"),
                        resultSet.getString("naziv"),
                        resultSet.getString("kolicina"),
                        resultSet.getString("datumIsteka"),
                        resultSet.getString("vrsta")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
