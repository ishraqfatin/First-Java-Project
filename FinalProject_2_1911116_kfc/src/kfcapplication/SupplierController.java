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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishraq Fatin
 */
public class SupplierController implements Initializable {

    @FXML
    private TableView<Supplier> tableView;
    @FXML
    private TableColumn<Supplier, String> nameCol;
    @FXML
    private TableColumn<Supplier, String> addressCol;
    @FXML
    private TableColumn<Supplier, String> emailCol;
    @FXML
    private TableColumn<Supplier, String> phoneCol;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

    private ObservableList<Supplier> oList = FXCollections.observableArrayList();

    private User u;

    public void setInfo(User h) {
        u = h;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<>("supName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("subAddress"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("supEmail"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("supPhone"));

        tableView.setItems(getSupplier());
    }

    public ObservableList<Supplier> getSupplier() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("SupplierList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Supplier a;
            while (true) {
                a = (Supplier) ois.readObject();

                oList.add(a);
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

        return oList;
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("ProcurementManager.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        ProcurementManagerController pmc = loader1.getController();
        pmc.setInfo(u);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void addButton(ActionEvent event) {
        if ("".equals(name.getText()) || "".equals(address.getText()) || "".equals(phone.getText()) || "".equals(email.getText())) {
            return;
        } else {
            Supplier s = new Supplier(
                    name.getText(),
                    address.getText(),
                    email.getText(),
                    phone.getText()
            );
            oList.add(s);

            s.supplierToBin();

        }

    }
}
