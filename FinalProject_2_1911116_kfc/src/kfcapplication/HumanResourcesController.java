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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class HumanResourcesController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    
    private User f;

    public void setInfo(User h) {
        f = h;
         nameLabel.setText(f.getName());
         idLabel.setText(Integer.toString(f.getId()));
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
    private void shortlistEmpButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("ShortlistEmpScene.fxml"));
        Parent homeScene1 = loader1.load();
        ShortlistEmpSceneController s = loader1.getController();
        s.setInfo(f);
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void checkQueryButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("QueryReply.fxml"));
        Parent homeScene1 = loader1.load();
        QueryReplyController q = loader1.getController();
        q.setInfo(f);
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void leaveRequestButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("LeaveRequestApprove.fxml"));
        Parent homeScene1 = loader1.load();
        LeaveRequestApproveController q = loader1.getController();
        q.setInfo(f);
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
