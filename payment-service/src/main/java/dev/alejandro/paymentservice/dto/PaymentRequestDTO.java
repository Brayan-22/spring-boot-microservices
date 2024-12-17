package dev.alejandro.paymentservice.dto;

public record PaymentRequestDTO(
        int orderId,
        double amount
) {
}
