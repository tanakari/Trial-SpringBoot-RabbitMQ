package com.example.mqsender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    private final String routingKey = "trial.springboot.rabbitmq.test";

    public void send(String message) throws Exception {
        rabbitTemplate.convertAndSend(
                MqSenderApplication.topicExchangeName,
                routingKey,
                message);
    }

}