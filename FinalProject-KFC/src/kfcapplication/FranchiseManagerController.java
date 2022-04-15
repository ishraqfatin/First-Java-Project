
package kfcapplication;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class FranchiseManagerController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    private User f;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    public void setInfo(User h) {
        f = h;
         nameLabel.setText(f.getName());
         idLabel.setText(Integer.toString(f.getId()));
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
    private void hireEmployeeButton(ActionEvent event) {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("HireEmployeeScene.fxml"));
            Parent homeScene1 = loader1.load();
            Scene homepage1 = new Scene(homeScene1);
            HireEmployeeSceneController controller1 = loader1.getController();
            controller1.setInfo(f);
            Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window1.setScene(homepage1);
            window1.show();
        } catch (IOException ex) {
            Logger.getLogger(FranchiseManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void writeReportButton(ActionEvent event) {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("Report.fxml"));
            Parent homeScene1 = loader1.load();
            Scene homepage1 = new Scene(homeScene1);
            ReportController controller1 = loader1.getController();
            controller1.setInfo(f);
            Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window1.setScene(homepage1);
            window1.show();
        } catch (IOException ex) {
            Logger.getLogger(FranchiseManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addBranchButton(ActionEvent event) {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("Branch.fxml"));
            Parent homeScene1 = loader1.load();
            Scene homepage1 = new Scene(homeScene1);
            BranchController controller1 = loader1.getController();
            controller1.setInfo(f);
            Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window1.setScene(homepage1);
            window1.show();
        } catch (IOException ex) {
            Logger.getLogger(FranchiseManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
