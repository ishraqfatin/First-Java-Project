package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modelclasses.Student;

public class FileHandlingDemoSceneController implements Initializable {

    @FXML    private TextField idTextField;
    @FXML    private TextField nameTextField;
    @FXML    private TextField cgpaTextField;
    @FXML    private TextField fileNameTextField;
    @FXML    private TextArea fileContentTextArea;
    @FXML    private Label fileContentLabel;

    ArrayList<Student> studList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studList = new ArrayList<Student>();
    }    

    @FXML
    private void saveToTextFileButtonOnClick(MouseEvent event) {
        try {
            /*
            //FileWriter fw = new FileWriter("test.txt");
            FileWriter fw = new FileWriter(fileNameTextField.getText());
            String content;            
            content =   idTextField.getText()+","+
                        nameTextField.getText()+","+
                        cgpaTextField.getText()+"\n";
            fw.write(content);
            fw.close();
            */
            
            FileWriter fw = new FileWriter(fileNameTextField.getText());
            String content;            
            for(Student st: studList){
                content =   st.getId()+","+
                        st.getName()+","+
                        st.getCgpa()+"\n";
                fw.write(content);
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex);
            //add custom handling code 
            //Logger.getLogger(FileHandlingDemoSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void readFromTextFileButtonOnClick(MouseEvent event) {
        try {
            File f = new File(fileNameTextField.getText());
            Scanner s = new Scanner(f);
            String content, line = s.nextLine();
            String[] tokens;
            tokens = line.split(",");
            content = "Id="+tokens[0]+", Name="+tokens[1]+", Cgpa="+tokens[2]+"\n";
            fileContentTextArea.setText(content);
            
            fileContentLabel.setText(content);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandlingDemoSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addToArrayListButtonOnClick(ActionEvent event) {
        studList.add(
                new Student(
                    Integer.parseInt(idTextField.getText()),
                    nameTextField.getText(),
                    Float.parseFloat(cgpaTextField.getText())
                )
        );   
        idTextField.clear();
        nameTextField.setText("");
        cgpaTextField.clear();
    }

    @FXML
    private void idTextFieldOnClick(MouseEvent event) {
        idTextField.clear();
    }

    @FXML
    private void nameTextFieldOnClick(MouseEvent event) {
        nameTextField.clear();
    }

    @FXML
    private void cgpaTextFieldOnClick(MouseEvent event) {
        cgpaTextField.clear();
    }
    
}
