/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class BranchController implements Initializable {

    @FXML
    private TextField branchPhoneText;
    @FXML
    private TextField branchNameText;
    @FXML
    private TextField branchAddressText;
    @FXML
    private TextField branchEmailText;
    @FXML
    private TableView<Branch> branchTable;
    @FXML
    private TableColumn<Branch, String> branchNameColumn;
    @FXML
    private TableColumn<Branch, String> addressColumn;
    @FXML
    private TableColumn<Branch, String> emailColumn;
    @FXML
    private TableColumn<Branch, String> phoneNumberColumn;

    private Branch b;
    private User fm;
    @FXML
    private TextArea outputText;

    public void setInfo(User f) {
        fm = f;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        branchNameColumn.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("branchAddress"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("branchEmail"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("branchPhone"));

        branchTable.setItems(getBranches());

    }

    public ObservableList<Branch> getBranches() {
        ObservableList<Branch> branches = FXCollections.observableArrayList();

        outputText.setText("");

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Branch.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Branch brn;
            try {
                outputText.setText("");
                while (true) {
                    System.out.println("Printing objects.");
                    brn = (Branch) ois.readObject();

                    System.out.println(brn.toString());
                    //outputText.appendText(brn.toString());
                    branches.add(brn);
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     
            outputText.appendText("Loade Successful\n");
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }

        return branches;

    }

    @FXML
    private void saveBranchButton(ActionEvent event) {

        outputText.setText("");
        if ("".equals(branchNameText.getText())
                || "".equals(branchAddressText.getText())
                || "".equals(branchPhoneText.getText())
                || "".equals(branchEmailText.getText())) {
            outputText.setText("Fields Empty");

        } else {

            Branch a = new Branch(
                    branchNameText.getText(),
                    branchAddressText.getText(),
                    branchPhoneText.getText(),
                    branchEmailText.getText()
            );
            a.addBranchObjectToBin();

            branchNameText.setText(null);
            branchAddressText.setText(null);
            branchPhoneText.setText(null);
            branchEmailText.setText(null);

            branchTable.setItems(getBranches());

        }
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("FranchiseManager.fxml"));
        Parent homeScene4 = loader4.load();
        Scene homepage4 = new Scene(homeScene4);
        FranchiseManagerController controller4 = loader4.getController();
        controller4.setInfo(fm);
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(homepage4);
        window4.show();

    }


}
