package com.producerservice._config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    Queue hImageQueue() {
        return new Queue("q.header.image", false);
    }

    @Bean
    Queue hVectorQueue() {
        return new Queue("q.header.vector", false);
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange("x.header.picture");
    }

    @Bean
    Binding hImageBinding(Queue hImageQueue, HeadersExchange headersExchange) {
        return BindingBuilder.bind(hImageQueue).to(headersExchange).where("image-type").matches("jpg");
    }

    @Bean
    Binding hVectorBinding(Queue hVectorQueue, HeadersExchange headersExchange) {
        return BindingBuilder.bind(hVectorQueue).to(headersExchange).where("image-type").matches("png");
    }

}
