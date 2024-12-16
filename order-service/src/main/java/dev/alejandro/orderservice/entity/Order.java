package dev.alejandro.orderservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "\"order\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "\"order_id\"")
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"quantity\"")
    private int quantity;
    @Column(name = "\"price\"")
    private double price;
}
