/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class ReportController implements Initializable {

    @FXML
    private TextArea writeText;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea previewText;

    private User fm;
    @FXML
    private ComboBox<String> chooseBranchCombo;
    @FXML
    private Text errorText;

    private String format = "";
    @FXML
    private Text blueText;

    public void setInfo(User f) {
        fm = f;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                    chooseBranchCombo.getItems().add(b.getBranchName());
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
    private void backButton(ActionEvent event) {
        try {
            
            FXMLLoader loader4 = new FXMLLoader();
            loader4.setLocation(getClass().getResource("FranchiseManager.fxml"));
            Parent homeScene4 = loader4.load();
            Scene homepage4 = new Scene(homeScene4);
            FranchiseManagerController controller4 = loader4.getController();
            controller4.setInfo(fm);
            Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window4.setScene(homepage4);
            window4.show();
        } catch (IOException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private String generateReport(ActionEvent e) {

        //This will collect data such as Date, Branch, Sales
        //and the message and show them in previewArea in a fixed format
        if ("".equals(datePicker.getValue()) || "".equals(chooseBranchCombo.getValue()) || "".equals(writeText.getText())) {
            errorText.setText("Empty Fields");
        } else {
            format = "Date: " + datePicker.getValue().toString() + "\n\n"
                    + "Generated By: " + fm.getName() + ", " + fm.getUserType() + "\nID:" + Integer.toString(fm.getId())
                    + "\n\nReport on " + chooseBranchCombo.getValue() + " Branch,\n"
                    + "\n" + writeText.getText();

            previewText.setText(format);
            errorText.setText("");
            blueText.setText("");


        }
        if (!"".equals(format)) {
            return format;
        }
        return null;
    }

    @FXML
    private void saveReport(ActionEvent event) {
        //This will save the output from the preview area into a text file
        //name of file will be the date and the branch
        if ("".equals(datePicker.getValue()) || "".equals(chooseBranchCombo.getValue()) || "".equals(writeText.getText())||"".equals(previewText.getText())) {
            errorText.setText("File NOT saved");
        } else {
            try {

                File f = null;
                FileWriter fw = null;

                f = new File("Report-" + datePicker.getValue() + "-" + chooseBranchCombo.getValue() + ".txt");
                fw = new FileWriter(f);
                fw.write(format);
                fw.close();
                
                blueText.setText("File Saved");
                errorText.setText("");
                writeText.setText("");
                previewText.setText("");
                
            } catch (IOException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
