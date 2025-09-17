package org.example.diceworld.database;

import org.example.diceworld.model.beans.Jugador;

import java.io.*;
import java.util.List;

public class Serializador {
    private String archivo;

    public Serializador(String archivo){
        this.archivo = archivo;
    }

    public void serializar(List<Jugador> jugadores) throws RuntimeException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(jugadores);

        } catch (IOException _){
            throw new RuntimeException("Error al serializar la lista de jugadores");
        }
    }

    public List<Jugador> getJugadores() throws FileNotFoundException, RuntimeException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
            return (List<Jugador>) ois.readObject();
        } catch (IOException | ClassNotFoundException _){
            throw new RuntimeException("Error al leer el archivo");
        }
    }
}
