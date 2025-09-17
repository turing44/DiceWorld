package org.example.diceworld;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DiceWorldController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
