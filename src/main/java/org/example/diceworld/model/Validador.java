package org.example.diceworld.model;

import org.example.diceworld.model.errors.FileFormatException;

import java.util.List;

public class Validador {
    private Validador(){}

    /**
     * Se asume que las extensiones permitidas siempre seran como: .xyz
     * @param archivo
     * @throws FileFormatException
     */
    public static void validarFormatoArchivo(String archivo) throws FileFormatException {
        List<String> extensionesPermitidas = List.of(".txt", ".dat");
        String extension;
        Integer posicionPunto = archivo.lastIndexOf(".");

        if (posicionPunto == -1) throw new FileFormatException();

        extension = archivo.substring(posicionPunto);

        if (!extensionesPermitidas.contains(extension)) {
            throw new FileFormatException();
        }
    }
}
