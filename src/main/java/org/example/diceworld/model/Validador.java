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
        if (archivo.isEmpty()) throw new FileFormatException();

        List<String> extensionesPermitidas = List.of(".txt", ".dat");

        String extension = obtenerExtension(archivo);

        if (!extensionesPermitidas.contains(extension)) {
            throw new FileFormatException();
        }
    }

    public static boolean esArchivoTXT(String archivo) {
        final String EXTENSION_TXT = ".txt";
        String extension = obtenerExtension(archivo);
        if (extension.equals(EXTENSION_TXT)) {
            return true;
        }
        return false;
    }

    private static String obtenerExtension(String archivo) {
        String extension;
        Integer posicionPunto = archivo.lastIndexOf(".");
        return archivo.substring(posicionPunto);
    }
}
