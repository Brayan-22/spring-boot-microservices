package dev.alejandro.orderservice.exceptions;

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String message) {
        super(message);
    }
}
