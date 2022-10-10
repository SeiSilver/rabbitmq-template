package com.consumerservice._config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Bean
    Queue tFilterQueue() {
        return new Queue("q.topic.picture.filter", false);
    }

    @Bean
    Queue tImageQueue() {
        return new Queue("q.topic.picture.image", false);
    }

    @Bean
    Queue tLogQueue() {
        return new Queue("q.topic.picture.log", false);
    }

    @Bean
    Queue tVectorQueue() {
        return new Queue("q.topic.picture.vector", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("x.topic.picture");
    }

    @Bean
    Binding tFilterBinding(Queue tFilterQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(tFilterQueue).to(topicExchange).with("mobile.#");
    }

    @Bean
    Binding tImageBinding(Queue tImageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(tImageQueue).to(topicExchange).with("#.jpg");
    }

    @Bean
    Binding tImage2Binding(Queue tImageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(tImageQueue).to(topicExchange).with("*.*.png");
    }

    @Bean
    Binding tLogBinding(Queue tLogQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(tLogQueue).to(topicExchange).with("*.large.svg");
    }

    @Bean
    Binding tVectorBinding(Queue tVectorQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(tVectorQueue).to(topicExchange).with("*.*.svg");
    }

}
