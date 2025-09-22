package org.example.diceworld;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.classfile.Label;

public class Application extends javafx.application.Application {
    @FXML
    Label mensaje;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("diceworld.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 600);
        stage.setTitle("DiceWorld");
        stage.setScene(scene);
        stage.show();
    }


}
