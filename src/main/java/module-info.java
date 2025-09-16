module org.example.diceworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.diceworld to javafx.fxml;
    exports org.example.diceworld;
}