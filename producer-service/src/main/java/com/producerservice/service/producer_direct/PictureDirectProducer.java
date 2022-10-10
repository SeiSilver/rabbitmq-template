package com.producerservice.service.producer_direct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producerservice.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureDirectProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureDirectProducer.class);

    public void sendMessage(Picture picture) throws JsonProcessingException {

        var json = objectMapper.writeValueAsString(picture);
        log.info(json);
        rabbitTemplate.convertAndSend("x.direct.picture", picture.getType(), json);

    }

}
