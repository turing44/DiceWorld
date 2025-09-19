package org.example.diceworld.model.procesos;

import org.example.diceworld.database.Archivador;
import org.example.diceworld.database.Serializador;
import org.example.diceworld.model.Validador;
import org.example.diceworld.model.beans.Dado;
import org.example.diceworld.model.beans.DatosPartida;
import org.example.diceworld.model.beans.Jugador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JuegoDados implements Juego {
    public List<Jugador> jugadores;

    public JuegoDados() {}


    @Override
    public void jugar(DatosPartida datosPartida) {
        // Validar datos partida
        // Validar que la lista de jugadores existe

        // Los dados que cada jugador usará en la partida
        List<Dado> dados = crearDados(datosPartida.getNumDados(), datosPartida.getNumCaras());

        for (int partida = 1; partida <= datosPartida.getNumPartidas(); partida++) {
            lanzarDadosDeTodosJugadores(dados);
            anotarResultados();
        }
    }

    @Override
    public void cargarDatos(String archivo) throws FileNotFoundException, RuntimeException {
        Validador.validarFormatoArchivo(archivo);

        if (Validador.esArchivoTXT(archivo)) {
            jugadores = Archivador.getJugadores(archivo);
        } else {
            jugadores = Serializador.getJugadores(archivo);
        }
    }

    @Override
    public void guardarDatos(String archivo) throws RuntimeException{
        Validador.validarFormatoArchivo(archivo);

        if (Validador.esArchivoTXT(archivo)) {
            Archivador.guardarJugadores(jugadores, archivo);
        } else {
            Serializador.serializar(jugadores, archivo);
        }
    }





    @Override
    public List<Jugador> getRankingPorPartidas() {
        jugadores.sort(
                (j1, j2) -> Integer.compare(j2.getPartidasGanadas(), j1.getPartidasGanadas())
        );
        return jugadores;
    }

    @Override
    public List<Jugador> getRankingPorPuntuacion() {
        jugadores.sort(
                (j1, j2) -> Integer.compare(j2.getPuntuacion(), j1.getPuntuacion())
        );
        return jugadores;
    }

    private List<Dado> crearDados(Integer numDados, Integer numCaras) {
        List<Dado> dados = new ArrayList<>();

        for (int i = 0; i < numDados; i++) {
            dados.add(new Dado(numCaras));
        }

        return dados;
    }

    private void lanzarDadosDeTodosJugadores(List<Dado> dados) {
        for (Jugador  jugador : jugadores) {
            jugador.lanzarDados(dados);
        }
    }


    /**
     * Devuelve la puntuación mas alta de la ultima partida jugada
     * Ej: robe 5
     *     luke 5
     *     han  4
     *
     *     devolveria 5
     *
     *
     * @return Integer
     */
    private Integer obtenerPuntuacionMayor() {
        List<Integer> puntuaciones = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            puntuaciones.add(jugador.getValorUltimaTirada());
        }
        return Collections.max(puntuaciones);
    }

    private void anotarResultados() {
        Integer puntuacionMayor = obtenerPuntuacionMayor();
        for (Jugador jugador : jugadores) {
            if (jugador.getValorUltimaTirada().equals(puntuacionMayor)) {
                jugador.ganarUnaPartida();
            }
        }
    }

}
