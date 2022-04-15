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
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HireEmployeeSceneController implements Initializable {

    @FXML
    private TextArea remarkText;
    @FXML
    private TableView<ShortlistEmp> tableView;
    @FXML
    private TableColumn<ShortlistEmp, String> nameCol;
    @FXML
    private TableColumn<ShortlistEmp, String> posCol;
    @FXML
    private TableColumn<ShortlistEmp, String> emailCol;
    @FXML
    private TableColumn<ShortlistEmp, String> phoneCol;
    @FXML
    private TableColumn<ShortlistEmp, String> branchCol;
    @FXML
    private Label messageLabel;

    private ObservableList<ShortlistEmp> oList = FXCollections.observableArrayList();

    private User fm;

    public void setInfo(User f) {
        fm = f;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        posCol.setCellValueFactory(new PropertyValueFactory<>("pos"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("selectedBranch"));

    }

    public ObservableList<ShortlistEmp> getEmp() {

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("ShortlistEmp.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ShortlistEmp a;
            try {

                while (true) {
//                    System.out.println("Printing objects.");
                    a = (ShortlistEmp) ois.readObject();

                    System.out.println(a.toString());
                    oList.add(a);
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

        return oList;
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FranchiseManager.fxml"));
        Parent p = loader1.load();
        Scene s = new Scene(p);
        FranchiseManagerController f = loader1.getController();
        f.setInfo(fm);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.show();
    }

    @FXML
    private void approveButtonClick(ActionEvent event) {
        ShortlistEmp s = tableView.getSelectionModel().getSelectedItem();

        Random random = new Random();

        int id = random.nextInt(900) + 100;
        String p = s.getPos();
        System.out.println(s.getPos());
        UserList u = new UserList();
        u.addUser(id, s.getName(), s.getPos(), s.getEmail(), Integer.toString(id), s.getSelectedBranch(),s.getPhone());
        messageLabel.setText("Candidate Hired!");

        oList.remove(s);
        ShortlistEmp.replaceEmpBin(oList);
        tableView.setItems(oList);
    }

    @FXML
    private void declineButtonClick(ActionEvent event) {
        ShortlistEmp s = tableView.getSelectionModel().getSelectedItem();
        oList.remove(s);
        messageLabel.setText("Candidate Removed.");
        ShortlistEmp.replaceEmpBin(oList);

    }

    @FXML
    private void loadTableButtonClick(ActionEvent event) throws IOException {
        tableView.setItems(getEmp());
        messageLabel.setText("Table loaded. Please select a candidate to Approve or Decline.");

    }

    @FXML
    private void selectPersonMouseClick(MouseEvent event) {
        ShortlistEmp s = tableView.getSelectionModel().getSelectedItem();
        String a = s.getRemarks();

        remarkText.setText(a);
    }

}
