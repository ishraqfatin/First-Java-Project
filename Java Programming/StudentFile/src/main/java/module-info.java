module main.studentfile {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.studentfile to javafx.fxml;
    exports main.studentfile;
}