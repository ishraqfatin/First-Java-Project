module com.example.demo1.HelloApplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo1.HelloApplication to javafx.fxml;
    exports com.example.demo1;
}