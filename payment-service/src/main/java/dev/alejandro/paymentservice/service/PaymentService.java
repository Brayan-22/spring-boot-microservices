package dev.alejandro.paymentservice.service;

import dev.alejandro.paymentservice.dto.PaymentRequestDTO;
import dev.alejandro.paymentservice.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO paymentDTO) throws IllegalArgumentException;
}
