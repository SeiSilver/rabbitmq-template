package com.producerservice.service.producer_header;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producerservice.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureHeaderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureHeaderProducer.class);

    public void sendMessage(Picture picture, MessageProperties headers) throws JsonProcessingException {

        var json = objectMapper.writeValueAsString(picture);
        log.info(json);

        MessageConverter messageConverter = new SimpleMessageConverter();

//        Message sysErrMsg = MessageBuilder.withBody(json.getBytes())
//                .andProperties(headers)
//                .build();

        Message message = messageConverter.toMessage(json, headers);

        rabbitTemplate.convertAndSend("x.header.picture", "", message);
    }

}
