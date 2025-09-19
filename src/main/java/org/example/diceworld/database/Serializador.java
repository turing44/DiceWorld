package org.example.diceworld.database;

import org.example.diceworld.model.beans.Jugador;

import java.io.*;
import java.util.List;

public class Serializador {
    private Serializador(){}

    public static void serializar(List<Jugador> jugadores, String archivo) throws RuntimeException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(jugadores);

        } catch (IOException _){
            throw new RuntimeException("Error al serializar la lista de jugadores");
        }
    }

    public static List<Jugador> getJugadores(String archivo) throws FileNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
            return (List<Jugador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            throw new FileNotFoundException("Error al leer el archivo");
        }
    }
}
