module com.labwork.javafxlabs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.labwork.javafxlabs to javafx.fxml;
    exports com.labwork.javafxlabs;
}