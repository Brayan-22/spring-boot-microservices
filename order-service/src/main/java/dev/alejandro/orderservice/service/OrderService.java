package dev.alejandro.orderservice.service;

import dev.alejandro.orderservice.dto.OrderDTO;
import dev.alejandro.orderservice.exceptions.EmptyCollectionException;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO) throws IllegalArgumentException;
    List<OrderDTO> getOrders() throws EmptyCollectionException;
    int deleteOrder(int orderId) throws IllegalArgumentException;
    OrderDTO getOrder(int orderId) throws IllegalArgumentException;
    OrderDTO updateOrder(int id,OrderDTO orderDTO) throws IllegalArgumentException;
}
