package dev.alejandro.orderservice.exceptions;

public class ParsingObjectException extends RuntimeException {
    public ParsingObjectException(Throwable e) {
        super(e.getMessage());
    }
}
