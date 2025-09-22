package org.example.diceworld.model.beans;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Jugador implements Serializable {
    private final String nombre;
    private Integer puntuacion;
    private Integer partidasGanadas;
    private Integer valorUltimaTirada;

    public Jugador(String datosCodificados) {
        String[] datos = datosCodificados.split(":");

        this.nombre = datos[0];
        this.partidasGanadas = Integer.parseInt(datos[1]);
        this.puntuacion = Integer.parseInt(datos[2]);

    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPuntuacion(){
        return puntuacion;
    }

    public Integer getPartidasGanadas() {
        return partidasGanadas;
    }

    public Integer getValorUltimaTirada(){
        return valorUltimaTirada;
    }

    private void setValorUltimaTirada(Integer valor){
        this.valorUltimaTirada = valor;
    }

    public void ganarUnaPartida(){
        partidasGanadas += 1;
    }

    @Override
    public String toString() {
        return this.nombre  + ":" + this.partidasGanadas + ":" + this.puntuacion;
    }

    public Integer lanzarDados(List<Dado> dados){
        // Según el enunciado siempre se jugará con dados iguales
        int numCaras = dados.getFirst().getNumCaras();
        int numDados = dados.size();

        int minimaPuntuacionPosible = numDados; // todos sacan 1
        int maximaPuntuacionPosible = numDados * numCaras; // todos sacan la cara máxima

        int resultado = ThreadLocalRandom.current()
                .nextInt(minimaPuntuacionPosible, maximaPuntuacionPosible + 1);

        this.guardarResultadoLanzamiento(resultado);

        return resultado;
    }

    private void guardarResultadoLanzamiento(Integer resultado){
        this.setValorUltimaTirada(resultado);
        this.puntuacion += resultado;
    }

    public void reiniciarPuntuacion() {
        this.puntuacion = 0;
        this.partidasGanadas = 0;
        this.setValorUltimaTirada(0);
    }
}
