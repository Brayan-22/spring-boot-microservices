package dev.alejandro.cloudgateway.controller;

import jakarta.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/orderFallback")
    public ResponseEntity<String> orderServiceFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Order Service is taking too long to respond or is down. Please try again later.");
    }
    @GetMapping("/paymentFallback")
    public ResponseEntity<String> paymentServiceFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Payment Service is taking too long to respond or is down. Please try again later.");
    }
}
