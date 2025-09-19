package org.example.diceworld;

import org.example.diceworld.database.Serializador;
import org.example.diceworld.model.Validador;
import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;
import org.example.diceworld.model.procesos.Juego;
import org.example.diceworld.model.procesos.JuegoDados;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        //javafx.application.Application.launch(Application.class, args);




        JuegoDados juegoDados = new JuegoDados();



        try {
            juegoDados.cargarDatos("jugadores.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        juegoDados.jugar(new DatosPartida(1,6,1));

        for (Jugador j : juegoDados.jugadores) {
            System.out.println(j);
        }

        juegoDados.guardarDatos("jugadores.txt");


    }
}
