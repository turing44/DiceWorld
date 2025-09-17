package org.example.diceworld.model.procesos;

import org.example.diceworld.database.Serializador;
import org.example.diceworld.model.Validador;
import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;

import java.io.FileNotFoundException;
import java.util.List;

public class JuegoDados implements Juego {
    private List<Jugador> jugadores;
    private Validador validador;

    public JuegoDados() {

    }

    @Override
    public void cargarDatos(String archivo) throws FileNotFoundException, RuntimeException {
        try {
            Validador.validarFormatoArchivo(archivo);
        } finally {

        }
    }

    @Override
    public void jugar(DatosPartida datosPartida) {

    }

    @Override
    public void guardarDatos(String archivo) throws RuntimeException{

    }

    @Override
    public List<Jugador> getRankingPorPartidas() {
        return List.of();
    }

    @Override
    public List<Jugador> getRankingPorPuntuacion() {
        return List.of();
    }
}
