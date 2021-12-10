
package fxmlapplicationpkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXMLApplicationClass extends Application {
    
    @Override
    public void start(Stage stg) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScene.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FileChooserView.fxml"));
        
        Scene scene = new Scene(root);
        
        stg.setTitle("Main Stage");
        stg.setScene(scene);
        stg.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);        
    }
    
}
