/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Subrata Kumar Dey
 */
public class ArithmeticOperationDemoSceneController implements Initializable {

    @FXML    private TextField xTextField;
    @FXML    private TextField yTextField;
    @FXML    private Label resultLabel;

    private String resultLabelContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        String xStr, yStr, resultStr;
        xStr = xTextField.getText();    //"12"
        yStr = yTextField.getText();    //"13"
        //resultStr = xStr + yStr;        //"1213"
        //Integer obj = 10;
        int xVal, yVal, sum;
        xVal = Integer.parseInt(xStr);  // int 12
        //xVal = Integer.parseInt("123");  // int 123
        //xVal = Integer.parseInt("123abd");  // exception, crash
        yVal = Integer.parseInt(yStr);  // int 13
        sum = xVal + yVal;              //int 25
        resultStr = Integer.toString(sum); //"25"
        resultLabel.setText("X + Y = " +resultStr);
    }

    @FXML
    private void subtractButtonOnClick(ActionEvent event) {
        resultLabel.setText(
            "X - y = " +
                    (Integer.parseInt(xTextField.getText())
                            -
                            Integer.parseInt(yTextField.getText()))
        );
    }

    @FXML
    private void multiplyButtonOnClick(ActionEvent event) {
        resultLabel.setText(
            "X * Y = " +
                    Integer.parseInt(xTextField.getText())
                            *
                            Integer.parseInt(yTextField.getText())
        );        
    }

    @FXML
    private void resultLabelMouseEnteredHandler(MouseEvent event) {
        resultLabelContent = resultLabel.getText();
        resultLabel.setText("You are hovering over the label... :-)");
    }

    @FXML
    private void resultLabelMouseExitHandler(MouseEvent event) {
        resultLabel.setText(resultLabelContent);
    }

    @FXML
    public void resetButton(ActionEvent actionEvent) {
        resultLabel.setText("");
    }
}
