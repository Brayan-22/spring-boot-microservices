package dev.alejandro.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO{
    private OrderDTO order;
    private String transactionId;
    private double amount;
    private String message;
}
