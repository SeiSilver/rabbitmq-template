package com.producerservice.service.producer_fanout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producerservice.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrFanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Employee employee) {

        try {
            var json = objectMapper.writeValueAsString(employee);
            System.out.println(json);
            rabbitTemplate.convertAndSend("x.fanout.hr", "", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
