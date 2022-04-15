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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShortlistEmpSceneController implements Initializable {

    @FXML
    private TableView<ShortlistEmp> tableView;
    @FXML
    private TableColumn<ShortlistEmp, String> nameColumn;
    @FXML
    private TableColumn<ShortlistEmp, String> posColumn;
    @FXML
    private TableColumn<ShortlistEmp, String> emailColumn;
    @FXML
    private TableColumn<ShortlistEmp, String> phoneColumn;
    @FXML
    private TableColumn<ShortlistEmp, String> branchColumn;
    @FXML
    private TextField nameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField phoneText;
    @FXML
    private ComboBox<String> posCombo;
    @FXML
    private Text messageLabel;
    @FXML
    private TextArea remarksText;

    private ObservableList<ShortlistEmp> oList = FXCollections.observableArrayList();

    private User fm;

    @FXML
    private ComboBox<String> branchCombo;

    public void setInfo(User f) {
        fm = f;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        posCombo.getItems().addAll(
                "Branch Manager",
                "Human Resources",
                "Customer Service Representative",
                "Procurement Manager"
        );

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        posColumn.setCellValueFactory(new PropertyValueFactory<>("pos"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<>("selectedBranch"));
        getBranch();

    }

    @FXML
    private void addToShortlistButton(ActionEvent event) {
        if ("".equals(nameText.getText())
                || "".equals(posCombo.getValue())
                || "".equals(emailText.getText())
                || "".equals(phoneText.getText())
                || "".equals(remarksText.getText())) {
            messageLabel.setText("Fields Empty");

        } else {
            ShortlistEmp s = new ShortlistEmp(
                    nameText.getText(),
                    posCombo.getValue(),
                    emailText.getText(),
                    phoneText.getText(),
                    remarksText.getText(),
                    branchCombo.getValue()
            );
            
            getEmp(s);
            tableView.setItems(oList);            

            messageLabel.setText("Table loaded.");
            nameText.setText(null);
            posCombo.setValue(null);
            branchCombo.setValue(null);
            emailText.setText(null);
            phoneText.setText(null);
            remarksText.setText(null);
        }
    }

    public void getEmp(ShortlistEmp a) {

        oList.add(a);
    }

    public void getBranch() {
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
                    branchCombo.getItems().add(b.getBranchName());
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
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("HumanResources.fxml"));
        Parent homeScene4 = loader4.load();
        Scene homepage4 = new Scene(homeScene4);
        HumanResourcesController controller4 = loader4.getController();
        controller4.setInfo(fm);
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(homepage4);
        window4.show();
    }

    @FXML
    private void deletePersonButton(ActionEvent event) {
        ShortlistEmp s=tableView.getSelectionModel().getSelectedItem();
        oList.remove(s);
        tableView.setItems(oList);
    }

    @FXML
    private void saveToFileButton(ActionEvent event) {
        ShortlistEmp.saveEmpToBin(oList);
        messageLabel.setText("File Saved");
    }

}
