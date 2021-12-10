package mainpkg.calculatorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
   @FXML private TextField yTextField;
   @FXML private TextField xTextField;
   @FXML private TextField resultTextField;


    @FXML
    public void onResetButtonClick(ActionEvent actionEvent) {
        resultTextField.setText("");
        xTextField.setText("");
        yTextField.setText("");
    }

    @FXML
    public void onADDButtonClick(ActionEvent actionEvent) {
        resultTextField.setText(
                "X + Y = " + (
                        (Float.parseFloat(xTextField.getText()))
                                +
                        (Float.parseFloat(yTextField.getText()))
                        )
        );
    }

    @FXML
    public void onMULTIPLYButtonClick(ActionEvent actionEvent) {
        resultTextField.setText(
                "X * Y = " +(
                        (Float.parseFloat(xTextField.getText()))
                                *
                        (Float.parseFloat(yTextField.getText()))
                )
        );
    }

    @FXML
    public void onSUBTRACTButtonClick(ActionEvent actionEvent) {
        resultTextField.setText(
                "X - Y = " +(
                        (Float.parseFloat(xTextField.getText()))
                                -
                        (Float.parseFloat(yTextField.getText()))
                )
        );
    }
}