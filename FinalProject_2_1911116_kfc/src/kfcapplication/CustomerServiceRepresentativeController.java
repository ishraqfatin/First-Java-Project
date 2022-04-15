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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CustomerServiceRepresentativeController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;

    User u;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, Integer> taskNoCol;
    @FXML
    private TableColumn<Task, String> taskCol;
    @FXML
    private TableColumn<Task, LocalDate> dateCol;
    @FXML
    private TableColumn<Task, Boolean> statCol;

    private ObservableList<Task> oList = FXCollections.observableArrayList();
    private ObservableList<Task> oList2 = FXCollections.observableArrayList();

    public void setInfo(User h) {
        u = h;
        nameLabel.setText(u.getName());
        idLabel.setText(Integer.toString(u.getId()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        taskNoCol.setCellValueFactory(new PropertyValueFactory<>("taskNo"));
        taskCol.setCellValueFactory(new PropertyValueFactory<>("task"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        statCol.setCellValueFactory(new PropertyValueFactory<>("taskStatus"));
        
        

    }

    public ObservableList<Task> getTasks() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Tasks.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Task t;
            while (true) {
                t = (Task) ois.readObject();
                oList.add(t);
                if(t.getDoerId()== u.getId()){
                    oList2.add(t);
                }  
            }
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceRepresentativeController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceRepresentativeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return oList2;
    }

    @FXML
    private void logOutButon(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("HomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void queryButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("QueryMaker.fxml"));
        Parent homeScene1 = loader1.load();
        QueryMakerController q = loader1.getController();
        q.setInfo(u);
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void requestLeaveButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("LeaveRequest.fxml"));
        Parent homeScene1 = loader1.load();
        LeaveRequestController q = loader1.getController();
        q.setInfo(u);
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void markDoneButtonClick(ActionEvent event) {
        Task s= taskTable.getSelectionModel().getSelectedItem();
        s.setTaskStatus(true);
        
        oList.remove(s);
        Task.replaceTaskBin(oList);
        
        oList2.remove(s);
        oList2.add(s);
        Task.completedTasksToBin(oList2);
    }

    @FXML
    private void showTaskButton(ActionEvent event) {
        taskTable.setItems(getTasks());
    }

}
