/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class ProcurementManagerController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
   

    private User u;
    
    public void setInfo(User h) {
        u = h;
         nameLabel.setText(u.getName());
         idLabel.setText(Integer.toString(u.getId()));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutButon(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("HomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void addSupplierButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("Supplier.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        SupplierController tsk = loader1.getController();
        tsk.setInfo(u);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void deleteSupplierButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("SupplierDelete.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        SupplierDeleteController tsk = loader1.getController();
        tsk.setInfo(u);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
