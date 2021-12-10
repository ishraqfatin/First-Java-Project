module mainpkg.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.calculatorfx to javafx.fxml;
    exports mainpkg.calculatorfx;
}