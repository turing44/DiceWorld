package org.example.diceworld.database;

import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;
import org.example.diceworld.model.errors.FileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivador {
    public static void guardarJugadores(List<Jugador> jugadores, String archivo) throws FileFormatException {

        try (FileWriter fw = new FileWriter(archivo)) {
            for (Jugador jugador : jugadores) {
                fw.write(jugador.toString());
            }
        } catch (IOException _) {
            throw new RuntimeException();
        }


    }
    public static List<Jugador> getJugadores(String archivo) throws FileFormatException {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                jugadores.add(new Jugador(linea));
            }
        } catch (IOException e) {
            throw new FileFormatException();
        }
        return jugadores;
    }
}
