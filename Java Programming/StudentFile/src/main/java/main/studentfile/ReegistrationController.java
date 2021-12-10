package main.studentfile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.modelclass.Student;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;



public class ReegistrationController {

    @FXML private TextField cgpaText;
    @FXML private TextField fileNameText;
    @FXML private TextField nameText;
    @FXML private TextField idText;
    @FXML private TextArea showFile;

    public ArrayList<Student> studentList;

    public void initialize(){
        studentList = new ArrayList<Student>();
    }


    @FXML
    public void saveFileButton(ActionEvent actionEvent) {


        try {
            File myFile = new File(fileNameText.getText()); // creates a new file
            FileWriter fw = new FileWriter(myFile, true); // appends the existing file

            for (Student st: studentList) {
                String content = st.getName() + "," + st.getId()+"," + st.getCgpa() + "\n";
                fw.write(content);
            }
            fw.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e);
        }

    }

    @FXML
    public void addFileButton(ActionEvent actionEvent) {
        studentList.add(
                new Student(
                        Integer.parseInt(idText.getText()),
                        nameText.getText(),
                        Float.parseFloat(cgpaText.getText())
                )
        );
        idText.clear();
        nameText.clear();
        cgpaText.clear();

    }

    @FXML
    public void showListButton(ActionEvent actionEvent) {
        try {
            File fr = new File(fileNameText.getText());
            Scanner s = new Scanner(fr);
            String[] data;
            String content, line;

            while (s.hasNextLine()) {
                line = s.nextLine();
                data = line.split(",");
                content = "Name: " + data[0] + " ID: " + data[1] + " CGPA: " + data[2] + "\n";

                showFile.appendText(content);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}