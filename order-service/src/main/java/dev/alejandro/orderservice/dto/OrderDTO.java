package dev.alejandro.orderservice.dto;

public record OrderDTO(
        Integer id,
        String name,
        Integer quantity,
        Double price
) {
}
