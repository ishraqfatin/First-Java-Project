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
import java.util.Scanner;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ishraq Fatin
 */
public class HomeSceneController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private ComboBox<String> branchComboBox;
    @FXML
    private Label errorLabel;
    
    private User u;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userComboBox.getItems().addAll(
                "Franchise Manager",
                "Branch Manager",
                "Human Resources",
                "Customer Service Representative",
                "Procurement Manager"
        );

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
    private void loginButtonClick(ActionEvent event) throws IOException {
        if ("".equals(idTextField.getText()) || "".equals(passwordTextField.getText())) {
            errorLabel.setText("Fields are Empty");
        } else {
             u = User.verifyLogin(Integer.parseInt(idTextField.getText()),
                    passwordTextField.getText(),
                    userComboBox.getValue(),
                    branchComboBox.getValue()
            );

            if (u == null) {
                errorLabel.setText("Invalid ID or Password");
            } else {
                if (u instanceof FranchiseManager) {

                    FXMLLoader loader1 = new FXMLLoader();
                    loader1.setLocation(getClass().getResource("FranchiseManager.fxml"));
                    Parent homeScene1 = loader1.load();
                    Scene homepage1 = new Scene(homeScene1);
                    FranchiseManagerController fmc = loader1.getController();
                    fmc.setInfo((FranchiseManager) u);
                    Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window1.setScene(homepage1);
                    window1.show();
                } else if (u instanceof BranchManager) {
                    FXMLLoader loader2 = new FXMLLoader();
                    loader2.setLocation(getClass().getResource("BranchManager.fxml"));
                    Parent homeScene2 = loader2.load();
                    Scene homepage2 = new Scene(homeScene2);
                    BranchManagerController bmc = loader2.getController();
                    bmc.setInfo((BranchManager) u);
                    Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window1.setScene(homepage2);
                    window1.show();
            } else if (u instanceof HumanResources) {
                FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("HumanResources.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                HumanResourcesController hrc = loader3.getController();
                hrc.setInfo((HumanResources) u);
                Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window1.setScene(homepage3);
                window1.show();
            } 
            else if (u instanceof CustomerServiceRepresentative) {
                FXMLLoader loader4 = new FXMLLoader();
                loader4.setLocation(getClass().getResource("CustomerServiceRepresentative.fxml"));
                Parent homeScene4 = loader4.load();
                Scene homepage4 = new Scene(homeScene4);
                CustomerServiceRepresentativeController csrc = loader4.getController();
                csrc.setInfo((CustomerServiceRepresentative) u);
                Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window1.setScene(homepage4);
                window1.show();
            } 
            else if (u instanceof ProcurementManager) {
                FXMLLoader loader5 = new FXMLLoader();
                loader5.setLocation(getClass().getResource("ProcurementManager.fxml"));
                Parent homeScene5 = loader5.load();
                Scene homepage5 = new Scene(homeScene5);
                ProcurementManagerController pmc = loader5.getController();
                pmc.setInfo((ProcurementManager) u);
                Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window1.setScene(homepage5);
                window1.show();
                }
            }
        }
    }


@FXML
        private void adminButtonClick(ActionEvent event) throws IOException {

        Parent scene2Parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }

    @FXML
        private void loginBranchClick(MouseEvent event) {

    }

}
