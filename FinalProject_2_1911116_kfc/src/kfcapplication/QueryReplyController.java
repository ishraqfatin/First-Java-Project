package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class QueryReplyController implements Initializable {

    @FXML
    private TextArea queryText;
    @FXML
    private TableView<Query> tableView;
    @FXML
    private TableColumn<Query, Integer> idCol;
    @FXML
    private TableColumn<Query, String> depCol;
    @FXML
    private TableColumn<Query, String> subCol;
    @FXML
    private TableColumn<Query, Date> dateCol;
    @FXML
    private TextArea replyText;

    private ObservableList<Query> oList = FXCollections.observableArrayList();

    private User fm;
    @FXML
    private Label label;
    @FXML
    private DatePicker datePicker;

    public void setInfo(User f) {
        fm = f;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        depCol.setCellValueFactory(new PropertyValueFactory<>("dep"));
        subCol.setCellValueFactory(new PropertyValueFactory<>("sub"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(getQuery());
    }

    public ObservableList<Query> getQuery() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            f = new File("Query.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            Query i;

            try {
                while (true) {
                    i = (Query) ois.readObject();
                    oList.add(i);
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
        return oList;
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("HumanResources.fxml"));
        Parent homeScene4 = loader4.load();
        Scene homepage4 = new Scene(homeScene4);
        HumanResourcesController controller4 = loader4.getController();
        controller4.setInfo(fm);
        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window4.setScene(homepage4);
        window4.show();
    }

    @FXML
    private void replyButtonClick(ActionEvent event) {
        Query q = tableView.getSelectionModel().getSelectedItem();
        q.setQueryReply(replyText.getText());
        q.setReplyDate(datePicker.getValue());
        q.setReplierId(fm.getId());
        q.setReplierDep(fm.getUserType());
        
        q.saveQueryReplyToFile();
        
        oList.remove(q);
        q.replaceQueryBin(oList);
    }

    @FXML
    private void selectQuery(MouseEvent event) {
        Query q = tableView.getSelectionModel().getSelectedItem();
        queryText.setText(q.toStringQuery());
    }

}
