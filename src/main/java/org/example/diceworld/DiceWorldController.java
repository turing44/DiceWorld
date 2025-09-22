package org.example.diceworld;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;
import org.example.diceworld.model.procesos.Juego;
import org.example.diceworld.model.procesos.JuegoDados;

import java.io.FileNotFoundException;

public class DiceWorldController {

    @FXML
    TextField campoArchivo;
    @FXML
    TextField campoNumDados;
    @FXML
    TextField campoNumCaras;
    @FXML
    TextField campoNumPartidas;
    @FXML
    TextArea areaRankingPartidas;
    @FXML
    TextArea areaRankingPuntos;
    @FXML
    Label mensaje;

    @FXML
    Button btnSalir;
    @FXML
    Button btnJugar;


    Juego juego = new JuegoDados();

    @FXML
    public void initialize() {
        campoNumDados.setText("");
    }

    @FXML
    public void jugar() {
        // validar entradas

        int numDados = Integer.parseInt(campoNumDados.getText());
        int numCaras = Integer.parseInt(campoNumCaras.getText());
        int numPartidas = Integer.parseInt(campoNumPartidas.getText());

        DatosPartida datosPartida = new DatosPartida(numPartidas, numDados, numCaras);

        juego.jugar(datosPartida);

        actualizarRankings();

    }

    @FXML
    public void salir() {
        Platform.exit();

    }

    @FXML
    public void cargarDatos() {

        try {
            juego.cargarDatos(campoArchivo.getText());
            actualizarRankings();


        } catch (FileNotFoundException e) {
            mensaje.setText("No se encontro el archivo");
        } catch (RuntimeException rte) {
            mensaje.setText("Formato incorrecto");
        }


    }

    @FXML
    public void guardarDatos() {
        juego.guardarDatos(campoArchivo.getText());

    }

    private void actualizarRankings() {
        limpiarRankings();

        for (Jugador jugador : juego.getRankingPorPartidas()) {
            areaRankingPartidas.setText(
                    areaRankingPartidas.getText() + jugador + "\n"
            );
        }
        for (Jugador jugador : juego.getRankingPorPuntuacion()) {
            areaRankingPuntos.setText(
                    areaRankingPuntos.getText() + jugador + "\n"
            );
        }
    }

    private void limpiarRankings() {
        areaRankingPartidas.clear();
        areaRankingPuntos.clear();
    }


}
