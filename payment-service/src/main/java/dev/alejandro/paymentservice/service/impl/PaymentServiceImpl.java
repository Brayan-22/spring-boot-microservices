package dev.alejandro.paymentservice.service.impl;

import dev.alejandro.paymentservice.dto.PaymentRequestDTO;
import dev.alejandro.paymentservice.dto.PaymentResponseDTO;
import dev.alejandro.paymentservice.entity.PaymentEntity;
import dev.alejandro.paymentservice.repository.PaymentRepository;
import dev.alejandro.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentDTO) throws IllegalArgumentException {
        if(Objects.isNull(paymentDTO)) throw new IllegalArgumentException("Invalid payment request");
        if(paymentDTO.status().isBlank()) throw new IllegalArgumentException("Invalid payment status");
        PaymentEntity payment = PaymentEntity
                .builder()
                .status(paymentDTO.status())
                .transtactionId(UUID.randomUUID().toString())
                .build();
        PaymentEntity p = paymentRepository.save(payment);
        return new PaymentResponseDTO(p.getId(), p.getStatus(), p.getTranstactionId());
    }
}
