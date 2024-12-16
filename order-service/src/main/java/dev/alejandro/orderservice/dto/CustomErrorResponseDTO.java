package dev.alejandro.orderservice.dto;

import org.springframework.http.HttpStatus;

public record CustomErrorResponseDTO(
        HttpStatus status,
        String errorMessage,
        String errorCode
) {
}
