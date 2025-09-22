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
    @FXML Button btnGuardarDatos;

    Juego juego = new JuegoDados();

    @FXML
    public void initialize() {
        areaRankingPartidas.setEditable(false);
        areaRankingPuntos.setEditable(false);

        desactivarBotonesJuego(true);
    }

    @FXML
    public void jugar() {
        limpiarMensajeYArchivo();

        int numDados;
        int numCaras;
        int numPartidas;
        DatosPartida datosPartida;

        try {
            numDados = ValidadorVista.getEnteroPositivo(campoNumDados.getText());
            numCaras = ValidadorVista.getEnteroPositivo(campoNumCaras.getText());
            numPartidas = ValidadorVista.getEnteroPositivo(campoNumPartidas.getText());

            datosPartida = new DatosPartida(numPartidas, numDados, numCaras);

            juego.jugar(datosPartida);

        } catch (NumberFormatException nfe) {
            mensaje.setText(nfe.getMessage());
        } catch (Exception _) {
            mensaje.setText("Error inesperado");
        }

        actualizarRankings();
    }

    @FXML
    public void salir() {
        Platform.exit();
    }

    @FXML
    public void cargarDatos() {
        if (campoArchivo.getText().isBlank()) {
            mensaje.setText("No has introducido ningun nombre");
        } else {
            try {
                juego.cargarDatos(campoArchivo.getText());
                actualizarRankings();
                limpiarMensajeYArchivo();
                desactivarBotonesJuego(false);


            } catch (FileNotFoundException e) {
                mensaje.setText("No se encontro el archivo");
            } catch (RuntimeException rte) {
                mensaje.setText("Formato incorrecto");
            } catch (Exception _) {
                mensaje.setText("Error inesperado");
            }


        }



    }

    @FXML
    public void guardarDatos() {
        if (campoArchivo.getText().isBlank()) {
            mensaje.setText("No has introducido ningun nombre");
        } else {

            try {
                juego.guardarDatos(campoArchivo.getText());
                limpiarMensajeYArchivo();
                mensaje.setText("Archivo guardado correctamente");
            } catch (RuntimeException _) {
                mensaje.setText("Formato incorrecto");
            } catch (Exception _) {
                mensaje.setText("Error inesperado");
            }


        }




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

    private void limpiarMensajeYArchivo() {
        mensaje.setText("");
        campoArchivo.clear();
    }

    private void desactivarBotonesJuego(boolean habilitados) {
        campoNumDados.setDisable(habilitados);
        campoNumCaras.setDisable(habilitados);
        campoNumPartidas.setDisable(habilitados);

        btnJugar.setDisable(habilitados);
        btnGuardarDatos.setDisable(habilitados);
    }


}
