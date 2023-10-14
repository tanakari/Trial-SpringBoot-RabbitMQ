package com.example.mqsender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MqSenderApplication {

	static final String topicExchangeName = "Trial-SpringBoot-RabbitMQ_ExchangeName";
	static final String queueName = "Trial-SpringBoot-RabbitMQ_QueueName";
	static final String routingKey = "trial.springboot.rabbitmq.#";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	public static void main(String[] args) {
		SpringApplication.run(MqSenderApplication.class, args);
	}

}
