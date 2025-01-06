package dev.alejandro.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.alejandro.orderservice.dto.OrderDTO;
import dev.alejandro.orderservice.dto.TransactionRequestDTO;
import dev.alejandro.orderservice.dto.TransactionResponseDTO;
import dev.alejandro.orderservice.entity.Order;
import dev.alejandro.orderservice.exceptions.EmptyCollectionException;
import dev.alejandro.orderservice.exceptions.ParsingObjectException;

import java.util.List;

public interface  OrderService {
    OrderDTO createOrder(OrderDTO orderDTO) throws IllegalArgumentException, ParsingObjectException;
    List<OrderDTO> getOrders() throws EmptyCollectionException;
    int deleteOrder(int orderId) throws IllegalArgumentException;
    OrderDTO getOrder(int orderId) throws IllegalArgumentException;
    OrderDTO updateOrder(int id,OrderDTO orderDTO) throws IllegalArgumentException;
    TransactionResponseDTO saveOrder(TransactionRequestDTO transactionRequestDTO) throws IllegalArgumentException,ParsingObjectException;
}
