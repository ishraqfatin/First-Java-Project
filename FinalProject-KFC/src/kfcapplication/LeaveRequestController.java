/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class LeaveRequestController implements Initializable {

    @FXML
    private TextField reasonText;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private TextArea previewText;
    @FXML
    private RadioButton sickRadio;
    @FXML
    private RadioButton casualRadio;

    private String typeOfLeave;

    private ToggleGroup tg,tg2;

    private LeaveRequest l;

    private User u;

    public void setInfo(User h) {
        u = h;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg = new ToggleGroup();
        sickRadio.setToggleGroup(tg);
        casualRadio.setToggleGroup(tg);

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerServiceRepresentative.fxml"));
        Parent p = loader.load();
        Scene s = new Scene(p);
        CustomerServiceRepresentativeController c = loader.getController();
        c.setInfo(u);
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(s);
        window4.show();
    }

    @FXML
    private void genratePreviewButton(ActionEvent event) {
        if ("".equals(reasonText.getText())
                || "".equals(typeOfLeave)
                || fromDate.getValue() == null
                || toDate.getValue() == null) {

        } else {
            l = new LeaveRequest(
                    u.getName(),
                    u.getBranch(),
                    u.getUserType(),
                    reasonText.getText(),
                    typeOfLeave,
                    fromDate.getValue(),
                    toDate.getValue(),
                    u.getId(),
                    false
            );
            previewText.setText(l.makeFormat());
        }
    }

    @FXML
    private void sendRequestButton(ActionEvent event) {
        if ("".equals(previewText.getText())) {
            System.out.println("Invalid Fields");
        } else {
            l.sendRequest();
            previewText.setText("Request Sent...");
        }
    }

    @FXML
    private void radioButtonClick(ActionEvent event) {
        if (sickRadio.isSelected()) {
            typeOfLeave = "sick";
        } else if (casualRadio.isSelected()) {
            typeOfLeave = "casual";
        } else {
            typeOfLeave = "";
        }
    }

    @FXML
    private void loadRequestsButton(ActionEvent event) {

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("ApprovedLeaveRequest.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            LeaveRequest a;
            try {

                while (true) {

                    a = (LeaveRequest) ois.readObject();
                    if (u.getId() == a.getReqId()) {
                        if (a.getIstrue() == true) {
                            previewText.appendText(a.getReason()
                                    + " Leave Request from " + a.getFromDate() + " to " + a.getToDate()
                                    + "\nhas been [APPROVED]");
                        } else if (a.getIstrue() == false) {
                            previewText.appendText(a.getReason()
                                    + " Leave Request from " + a.getFromDate() + " to " + a.getToDate()
                                    + "\nhas been [DENIED]");
                        }
                    }

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

}
