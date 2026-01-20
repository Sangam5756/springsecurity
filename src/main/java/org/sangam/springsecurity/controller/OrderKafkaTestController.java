package org.sangam.springsecurity.controller;


import lombok.AllArgsConstructor;
import org.sangam.springsecurity.services.OrderEventProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderKafkaTestController {

    private final OrderEventProducer producer;


    @PostMapping("/{orderId}")
    public String createOrder(@PathVariable String orderId) {
        producer.sendOrderCreatedEvent(orderId);
        return "Order event sent for " + orderId;
    }
}
