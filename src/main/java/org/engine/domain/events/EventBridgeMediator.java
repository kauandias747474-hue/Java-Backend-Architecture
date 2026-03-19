package com.evento;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventBridgeMediator {
    private final RabbitTemplate rabbitTemplate;

    public EventBridgeMediator(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(DomainEvent event) {
     
        rabbitTemplate.convertAndSend("finance_events_queue", event);
        System.out.println(">>> EVENTO ENVIADO AO RABBITMQ: " + event.trackingCode());
    }
}
