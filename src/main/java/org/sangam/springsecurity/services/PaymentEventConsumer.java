package org.sangam.springsecurity.services;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEventConsumer {


    @KafkaListener(
            topics = "order-events",
            groupId = "payment-service"
    )
    public void handleOrderEvent(String message) {
        System.out.println("Received event: " + message);

        // simulate payment processing
    }
}
