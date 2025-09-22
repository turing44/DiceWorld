package org.example.diceworld;

public class ValidadorVista {
    public static int getEnteroPositivo(String texto) throws NumberFormatException{
        if (texto.isBlank()) throw new NumberFormatException("No has rellenado todos los campos");

        int numero;

        try {
            numero = Integer.parseInt(texto.trim());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Solo puedes introducir numeros");
        }


        if (numero < 0) {
            throw new NumberFormatException("No puedes introducir un numero negativo");
        }

        return numero;
    }
}
