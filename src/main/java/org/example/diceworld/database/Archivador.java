package org.example.diceworld.database;

import org.example.diceworld.model.beans.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivador {
    public static void guardarJugadores(List<Jugador> jugadores, String archivo) throws RuntimeException {

        try (FileWriter fw = new FileWriter(archivo)) {
            for (Jugador jugador : jugadores) {
                fw.write(jugador.toString() + "\n");
            }
        } catch (IOException _) {
            throw new RuntimeException();
        }


    }
    public static List<Jugador> getJugadores(String archivo) throws FileNotFoundException {

        List<Jugador> jugadores = new ArrayList<Jugador>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                jugadores.add(new Jugador(linea));
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return jugadores;
    }
}
