package dev.alejandro.paymentservice.service.impl;

import dev.alejandro.paymentservice.dto.PaymentRequestDTO;
import dev.alejandro.paymentservice.dto.PaymentResponseDTO;
import dev.alejandro.paymentservice.entity.PaymentEntity;
import dev.alejandro.paymentservice.repository.PaymentRepository;
import dev.alejandro.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentDTO) throws IllegalArgumentException {
        if(Objects.isNull(paymentDTO)) throw new IllegalArgumentException("Invalid payment request");
        if (paymentDTO.orderId() <= 0) throw new IllegalArgumentException("Invalid order id");
        if (paymentDTO.amount() <= 0) throw new IllegalArgumentException("Invalid amount");
        PaymentEntity payment = PaymentEntity
                .builder()
                .status(paymentProccesing())
                .transtactionId(UUID.randomUUID().toString())
                .orderId(paymentDTO.orderId())
                .amount(paymentDTO.amount())
                .build();
        PaymentEntity p = paymentRepository.save(payment);
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(
                p.getId(),
                p.getStatus(),
                p.getTranstactionId(),
                p.getOrderId(),
                p.getAmount()
        );
        log.info("Payment response data: {}",paymentResponseDTO);
        return paymentResponseDTO;
    }

    @Override
    public List<PaymentResponseDTO> getPayments() throws IllegalArgumentException {
        List<PaymentEntity> payments = paymentRepository.findAll();
        if(payments.isEmpty()) throw new IllegalArgumentException("No payments found");
        List<PaymentResponseDTO> paymentResponseDTOS = payments.stream().map(p -> new PaymentResponseDTO(
                p.getId(),
                p.getStatus(),
                p.getTranstactionId(),
                p.getOrderId(),
                p.getAmount()
        )).toList();
        log.info("Payments : {}",paymentResponseDTOS);
        return paymentResponseDTOS;
    }

    public String paymentProccesing(){
        //api should be 3rd party payment gateway
        return new Random().nextBoolean() ? "SUCCESS" : "FAILURE";
    }
}
