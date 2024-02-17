module com.aviraj.first.connectfour {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.aviraj.first.connectfour to javafx.fxml;
    exports com.aviraj.first.connectfour;
}