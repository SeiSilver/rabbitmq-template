 package com.consumerservice._config;

 import org.springframework.amqp.core.Binding;
 import org.springframework.amqp.core.BindingBuilder;
 import org.springframework.amqp.core.FanoutExchange;
 import org.springframework.amqp.core.Queue;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 @Configuration
 public class RabbitMQFanoutConfig {

     /*
       Fanout ko dùng routing key vi no de day message het tat cac queue dc binding voi no
     */

     @Bean
     Queue accountingQueue() {
         return new Queue("q.fanout.hr.accounting", false);
     }

     @Bean
     Queue marketingQueue() {
         return new Queue("q.fanout.hr.marketing", false);
     }

     @Bean
     FanoutExchange fanoutExchange() {
         return new FanoutExchange("x.fanout.hr");
     }

     @Bean
     Binding accountingBinding(Queue accountingQueue, FanoutExchange fanoutExchange) {
         return BindingBuilder.bind(accountingQueue).to(fanoutExchange);
     }

     @Bean
     Binding marketingBinding(Queue marketingQueue, FanoutExchange fanoutExchange) {
         return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
     }

 }
