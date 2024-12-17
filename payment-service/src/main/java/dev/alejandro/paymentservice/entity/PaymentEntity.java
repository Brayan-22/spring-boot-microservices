package dev.alejandro.paymentservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "\"payment\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 112312914820L;

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "payment_status")
    private String status;
    @Column(name = "transaction_id")
    private String transtactionId;

    @Column(name = "order_id")
    private int orderId;
    @Column(name = "amount")
    private double amount;
}
