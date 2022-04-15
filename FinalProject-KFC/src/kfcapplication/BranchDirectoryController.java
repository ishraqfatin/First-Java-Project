/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Ishraq Fatin
 */
public class BranchDirectoryController implements Initializable {

    @FXML
    private TableView<User> branchTable;
    private User u;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> desCol;

    @FXML
    private TableColumn<User, String> phoneCol;
    @FXML
    private TableColumn<User, String> emailCol;

    public void setInfo(User f) {
        u = f;
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("BranchManager.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        BranchManagerController brn = loader1.getController();
        brn.setInfo(u);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("userType"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }

    public ObservableList<User> getEmp() {
        ObservableList<User> oList = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("UserList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User a;
            while (true) {
                a = (User) ois.readObject();
                if (a.getBranch().equals(u.getBranch())
                        && "Customer Service Representative".equals(a.getUserType())) {
                    oList.add(a);

                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {

            }
        }

        return oList;
    }

    @FXML
    private void loadButton(ActionEvent event) {
        branchTable.setItems(getEmp());

    }

}
