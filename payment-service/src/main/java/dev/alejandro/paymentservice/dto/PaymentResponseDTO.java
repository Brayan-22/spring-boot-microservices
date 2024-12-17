package dev.alejandro.paymentservice.dto;

public record PaymentResponseDTO(
        int id,
        String status,
        String transactionId
) {
}
