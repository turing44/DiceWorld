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
        this.puntuacion = Integer.parseInt(datos[1]);
        this.partidasGanadas = Integer.parseInt(datos[2]);
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
        Integer resultado;

        // Segun el enunciado siempre se jugara con dados iguales
        Integer num_caras = dados.getFirst().getNumCaras();
        Integer num_dados = dados.size();

        Integer minimaPuntuacionPosible = dados.size();
        Integer maximaPuntuacionPosible = (int) Math.pow(num_caras, num_dados);

        resultado = ThreadLocalRandom.current().nextInt(minimaPuntuacionPosible, maximaPuntuacionPosible + 1);

        this.guardarResultadoLanzamiento(resultado);

        return resultado;
    }

    private void guardarResultadoLanzamiento(Integer resultado){
        this.setValorUltimaTirada(resultado);
        this.puntuacion += resultado;
    }
}
