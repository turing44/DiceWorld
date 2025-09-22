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
        javafx.application.Application.launch(Application.class, args);
    }
}
