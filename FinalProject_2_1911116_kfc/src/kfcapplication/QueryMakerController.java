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
import java.sql.Date;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class QueryMakerController implements Initializable {

    @FXML
    private TextArea queryMakeText;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField subField;
    @FXML
    private TextArea loadReplyTextArea;

    private User fm;

    public void setInfo(User h) {
        fm = h;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("CustomerServiceRepresentative.fxml"));
        Parent homeScene4 = loader4.load();
        Scene homepage4 = new Scene(homeScene4);
        if (fm instanceof CustomerServiceRepresentative) {
            CustomerServiceRepresentativeController controller4 = loader4.getController();
            controller4.setInfo(fm);
        }else if(fm instanceof BranchManager){
            BranchManagerController controller4 = loader4.getController();
            controller4.setInfo(fm);
        }
//        else if (fm instanceof ProcurementManager){
//            ProcurementManagerController controller4 = loader4.getController();
//            controller4.setInfo(fm);
//        }
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(homepage4);
        window4.show();
    }

    @FXML
    private void loadReplyButton(ActionEvent event) {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            f = new File("QueryReply.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            Query i;

            try {
                while (true) {
                    i = (Query) ois.readObject();
                    if (fm.getId() == i.getId()) {
                        loadReplyTextArea.appendText(i.toStringReply() + "\n\n");
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QueryReplyController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(QueryReplyController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void sendQueryButton(ActionEvent event) {
        Query q = new Query(
                fm.getUserType(),
                subField.getText(),
                datePicker.getValue(),
                fm.getId(),
                queryMakeText.getText()
        );
        q.saveQueryToFile();
    }

}
