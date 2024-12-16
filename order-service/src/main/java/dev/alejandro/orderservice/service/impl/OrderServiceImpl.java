package dev.alejandro.orderservice.service.impl;

import dev.alejandro.orderservice.dto.OrderDTO;
import dev.alejandro.orderservice.entity.Order;
import dev.alejandro.orderservice.exceptions.EmptyCollectionException;
import dev.alejandro.orderservice.repository.OrderRepository;
import dev.alejandro.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws IllegalArgumentException {
        if (orderDTO == null) {
            throw new IllegalArgumentException("OrderDTO cannot be null");
        }
        Order order = new Order(
                orderDTO.id(),
                orderDTO.name(),
                orderDTO.quantity(),
                orderDTO.price()
        );
        Order savedOrder = orderRepository.save(order);
        return new OrderDTO(
                savedOrder.getId(),
                savedOrder.getName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        );
    }

    @Override
    public List<OrderDTO> getOrders() throws EmptyCollectionException {
        List<OrderDTO> orders =  orderRepository.findAll()
                .stream()
                .map(o -> new OrderDTO(o.getId(),o.getName(),o.getQuantity(),o.getPrice()))
                .toList();
        if (orders.isEmpty()) {
            throw new EmptyCollectionException("No orders found");
        }
        return orders;
    }

    @Override
    public int deleteOrder(int orderId) {
        if (orderId <= 0 ) throw new IllegalArgumentException("The order id must be greater than 0");
        return orderRepository.deleteOrderById(orderId);
    }

    @Override
    public OrderDTO getOrder(int orderId) {
        if (orderId <= 0 ) throw new IllegalArgumentException("The order id must be greater than 0");
        Order order = orderRepository.findOrderById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return new OrderDTO(order.getId(),order.getName(),order.getQuantity(),order.getPrice());
    }

    @Override
    public OrderDTO updateOrder(int id,OrderDTO orderDTO) {
        if (orderDTO == null) throw new IllegalArgumentException("OrderDTO cannot be null");
        if (id <= 0 ) throw new IllegalArgumentException("The order id must be greater than 0");
        Order order = new Order(
                orderDTO.id(),
                orderDTO.name(),
                orderDTO.quantity(),
                orderDTO.price()
        );
        int response = orderRepository.updateOrderById(id,order);
        if (Objects.equals(response,0)) throw new IllegalArgumentException("Order not found");
        return new OrderDTO(order.getId(),order.getName(),order.getQuantity(),order.getPrice());
    }
}