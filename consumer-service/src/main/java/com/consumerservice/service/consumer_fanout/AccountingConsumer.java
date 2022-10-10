package com.consumerservice.service.consumer_fanout;

import com.consumerservice.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AccountingConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(AccountingConsumer.class);

    @RabbitListener(queues = "q.fanout.hr.accounting")
    public void listen(String message) {
        Employee employee;
        try {
            employee = objectMapper.readValue(message, Employee.class);
            log.info("On Accounting | employee: {}", employee.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
