package org.example.diceworld;

public class ValidadorVista {
    public static void validarEnteroPositivo(String numero) {
        numero = numero.trim();
        if (Integer.parseInt(numero) < 0) {
            throw new NumberFormatException();
        }

    }
}
