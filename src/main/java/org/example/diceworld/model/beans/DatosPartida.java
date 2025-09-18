package org.example.diceworld.model.beans;

public class DatosPartida {
    private Integer numPartidas;
    private Integer numCaras;
    private Integer numDados;

    public DatosPartida(Integer numPartidas, Integer numCaras, Integer numDados) {
        this.numPartidas = numPartidas;
        this.numCaras = numCaras;
        this.numDados = numDados;
    }

    public Integer getNumPartidas() {
        return numPartidas;
    }

    public Integer getNumCaras() {
        return numCaras;
    }

    public Integer getNumDados() {
        return numDados;
    }
}
