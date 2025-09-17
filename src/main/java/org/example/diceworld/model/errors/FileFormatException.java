package org.example.diceworld.model.errors;

public class FileFormatException extends RuntimeException {
    public FileFormatException(){}
    public FileFormatException(String message) {
        super(message);
    }
}
