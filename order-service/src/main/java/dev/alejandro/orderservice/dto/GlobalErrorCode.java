package dev.alejandro.orderservice.dto;

public class GlobalErrorCode {
    private GlobalErrorCode() {
    }
    public static final String ERROR_ORDER_NOT_FOUND = "ORDER_NOT_FOUND";
    public static final String GENERIC_ERROR = "GENERIC_ERROR";
    public static final String ERROR_EMPTY_COLLECTION = "EMPTY_COLLECTION";
    public static final String ERROR_ILLEGAL_ARGUMENT = "ILLEGAL_ARGUMENT";
}
