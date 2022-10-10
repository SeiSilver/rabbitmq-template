package com.consumerservice._config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    Queue imageQueue() {
        return new Queue("q.direct.image", false);
    }

    @Bean
    Queue vectorQueue() {
        return new Queue("q.direct.vector", false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("x.direct.picture");
    }

    @Bean
    Binding imageJPGBinding(Queue imageQueue, DirectExchange exchange) {
        return BindingBuilder.bind(imageQueue).to(exchange).with("jpg");
    }

    @Bean
    Binding imagePNGBinding(Queue imageQueue, DirectExchange exchange) {
        return BindingBuilder.bind(imageQueue).to(exchange).with("svg");
    }

    @Bean
    Binding vectorBinding(Queue vectorQueue, DirectExchange exchange) {
        return BindingBuilder.bind(vectorQueue).to(exchange).with("png");
    }

}
