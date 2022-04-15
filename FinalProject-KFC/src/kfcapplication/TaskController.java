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
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class TaskController implements Initializable {

    @FXML
    private TableView<User> empTable;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> emailCol;
    @FXML
    private TableColumn<User, String> desCol;
    @FXML
    private TableColumn<User, String> branchCol;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, Integer> taskNoCol;
    @FXML
    private TableColumn<Task, String> taskCol;
    @FXML
    private TableColumn<Task, LocalDate> dateCol;
    @FXML
    private TableColumn<Task, Integer> assignedToCol;
    @FXML
    private TextField taskText;
    @FXML
    private TextField taskNoText;
    @FXML
    private DatePicker date;

    private int noOfEmp;

    private ObservableList<User> oList1 = FXCollections.observableArrayList();
    private ObservableList<Task> oList2 = FXCollections.observableArrayList();

    private User u, a;
    @FXML
    private Label totalLabel;
    @FXML
    private Label messageLabel;

    public void setInfo(User h) {
        u = h;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("userType"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));

        taskNoCol.setCellValueFactory(new PropertyValueFactory<>("taskNo"));
        taskCol.setCellValueFactory(new PropertyValueFactory<>("task"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        assignedToCol.setCellValueFactory(new PropertyValueFactory<>("doerId"));
        
        
    }

    public ObservableList<User> getEmp() {
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
                    oList1.add(a);
                    noOfEmp++;
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

        return oList1;
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

    @FXML
    private void assignButton(ActionEvent event) {
        Task.taskToBin(oList2);
        
        messageLabel.setText("Task Assigned.");
    }

    @FXML
    private void deleteButton(ActionEvent event) {
        Task t = taskTable.getSelectionModel().getSelectedItem();
        oList2.remove(t);
        taskTable.setItems(oList2);
        taskTable.sort();

    }

    @FXML
    private void loadEmpTable(ActionEvent event) {

        if (empTable.getItems().isEmpty()) {
            empTable.setItems(getEmp());
            totalLabel.setText("No. of Employees you manage: " + noOfEmp);
        }

    }

    @FXML
    private void addTaskButton(ActionEvent event) {

        a = empTable.getSelectionModel().getSelectedItem();
        if ("".equals(taskNoText.getText()) || "".equals(taskText.getText()) || date.getValue() == null) {
            return;
        } else {
            Task t = new Task(
                    taskNoText.getText(),
                    taskText.getText(),
                    date.getValue(),
                    a.getId()
            );
            System.out.println(t.getDoerId());
            oList2.add(t);
            taskTable.setItems(oList2);

            taskNoText.setText("");
            taskText.setText("");
            date.setValue(null);
            
            taskTable.sort();
        }
    }

}
