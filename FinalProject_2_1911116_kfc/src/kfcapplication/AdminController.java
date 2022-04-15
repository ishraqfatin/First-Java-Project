/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class AdminController implements Initializable {

    @FXML
    private TextField getName;
    @FXML
    private TextField getID;
    @FXML
    private TextField getPassword;
    @FXML
    private ComboBox<String> userCombo;
    @FXML
    private TextField getEmail;
    private TextField getBranch;
    @FXML
    private TextArea userTextArea;
    @FXML
    private ComboBox<String> branchComboBox;
    @FXML
    private TextField getPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userCombo.getItems().addAll(
                "Franchise Manager",
                "Branch Manager",
                "Human Resources",
                "Customer Service Representative",
                "Procurement Manager"
        );

        getBranch();
    }

    @FXML
    public void addUserButton(ActionEvent event) {
        UserList u = new UserList();
        u.addUser(
                Integer.parseInt(getID.getText()),
                getName.getText(),
                userCombo.getValue(),
                getEmail.getText(),
                getPassword.getText(),
                branchComboBox.getValue(),
                getPhone.getText()
        );
        getID.setText("");
        getName.setText("");
        userCombo.setValue("");
        getEmail.setText("");
        getPassword.setText("");
        branchComboBox.setValue("");
        getPhone.setText("");

    }
    
    public void getBranch(){
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            f = new File("Branch.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Branch b;
            try {
                while (true) {
                    b = (Branch) ois.readObject();
                    branchComboBox.getItems().add(b.getBranchName());
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    

    @FXML
    private void viewUserButton(ActionEvent event) {
        userTextArea.setText("");
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("UserList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User emp;
            try {
                userTextArea.setText("");
                while (true) {
                    System.out.println("Printing objects.");
                    emp = (User) ois.readObject();

                    System.out.println(emp.toString());
                    userTextArea.appendText(emp.toString());
                }
            }//end of nested try
            catch (Exception e) {

            }//nested catch     
            userTextArea.appendText("All objects are loaded successfully...\n");
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    @FXML
    private void backToLogin(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }

}
