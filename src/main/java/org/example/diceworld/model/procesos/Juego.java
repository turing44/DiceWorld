package org.example.diceworld.model.procesos;

import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;

import java.io.FileNotFoundException;
import java.util.List;

public interface Juego {
    public List<Jugador> getRankingPorPartidas();
    public List<Jugador> getRankingPorPuntuacion();
    public void jugar(DatosPartida datosPartida);
    public void cargarDatos(String archivo) throws FileNotFoundException, RuntimeException;
    public void guardarDatos(String archivo) throws RuntimeException;
}
