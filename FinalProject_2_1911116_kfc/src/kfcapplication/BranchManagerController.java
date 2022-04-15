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


public class BranchManagerController implements Initializable {
    private User u;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    
    
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
    private void delgateTaskButton(ActionEvent event) throws IOException {
        FXMLLoader loader1= new FXMLLoader();
        loader1.setLocation(getClass().getResource("Task.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        TaskController tsk = loader1.getController();
        tsk.setInfo(u);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }


    @FXML
    private void branchDirectoryButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("BranchDirectory.fxml"));
        Parent p = loader1.load();
        Scene s = new Scene(p);
        BranchDirectoryController f = loader1.getController();
        f.setInfo(u);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.show();
    }

    
    
}
