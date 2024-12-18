package dev.alejandro.paymentservice.service;

import dev.alejandro.paymentservice.dto.PaymentRequestDTO;
import dev.alejandro.paymentservice.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO paymentDTO) throws IllegalArgumentException;
    List<PaymentResponseDTO> getPayments() throws IllegalArgumentException;
}
