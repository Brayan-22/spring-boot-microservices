package dev.alejandro.orderservice.controller;

import dev.alejandro.orderservice.dto.OrderDTO;
import dev.alejandro.orderservice.dto.TransactionRequestDTO;
import dev.alejandro.orderservice.dto.TransactionResponseDTO;
import dev.alejandro.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;


    @PostMapping("")
    public ResponseEntity<TransactionResponseDTO> bookOrder(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return ResponseEntity.ok(orderService.saveOrder(transactionRequestDTO));
    }

    @GetMapping("")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDTO));
    }
    
}
