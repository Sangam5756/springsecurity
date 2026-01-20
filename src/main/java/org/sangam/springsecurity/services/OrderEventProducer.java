package org.sangam.springsecurity.services;


import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendOrderCreatedEvent(String orderId) {
        String event = "orderCreatedEvent"+orderId;
        kafkaTemplate.send("order-events", orderId,event);

    }

}
