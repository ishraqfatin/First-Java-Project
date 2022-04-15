/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.DataInputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LeaveRequestApproveController implements Initializable {

    private User f;
    @FXML
    private TableView<LeaveRequest> tableView;
    @FXML
    private TableColumn<LeaveRequest, Integer> idCol;
    @FXML
    private TableColumn<LeaveRequest, String> nameCol;
    @FXML
    private TableColumn<LeaveRequest, String> branchCol;
    @FXML
    private TableColumn<LeaveRequest, String> depCol;
    @FXML
    private TextArea outputText;

    private LeaveRequest a;

    private ObservableList<LeaveRequest> oList = FXCollections.observableArrayList();

    public void setInfo(User h) {
        f = h;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<>("reqId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("reqName"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("reqBranch"));
        depCol.setCellValueFactory(new PropertyValueFactory<>("reqDes"));

        tableView.setItems(getRequests());
    }

    public ObservableList<LeaveRequest> getRequests() {

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("LeaveRequest.bin");
            if (!f.exists()) {
            } else {

                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                while (true) {
                    a = (LeaveRequest) ois.readObject();
                    oList.add(a);
                }//while
            }//else
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LeaveRequestApproveController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LeaveRequestApproveController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return oList;
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HumanResources.fxml"));
        Parent p = loader.load();
        Scene s = new Scene(p);
        HumanResourcesController c = loader.getController();
        c.setInfo(f);
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(s);
        window4.show();
    }

    @FXML
    private void approveButton(ActionEvent event) {
        a = tableView.getSelectionModel().getSelectedItem();

        a.setIstrue(true);

        a.approvedRequests();

        oList.remove(a);

        a.removeRequest(oList);

        outputText.setText("");
    }

    @FXML
    private void declineButton(ActionEvent event) {
        a = tableView.getSelectionModel().getSelectedItem();
        a.setIstrue(false);
        a.approvedRequests();

        oList.remove(a);
        a.removeRequest(oList);
        outputText.setText("");

    }

    @FXML
    private void selectTable(MouseEvent event) {
        a = tableView.getSelectionModel().getSelectedItem();
        outputText.setText(a.makeFormat());
    }

}
