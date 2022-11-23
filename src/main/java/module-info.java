module agh.ics.oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens agh.ics.oop to javafx.fxml;
    exports agh.ics.oop;
    exports agh.ics.oop.gui;
}