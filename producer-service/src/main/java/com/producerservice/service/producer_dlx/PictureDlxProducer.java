package com.producerservice.service.producer_dlx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producerservice.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureDlxProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureDlxProducer.class);

    public void sendMessage(Picture picture) throws JsonProcessingException {
        objectMapper.findAndRegisterModules();
        var json = objectMapper.writeValueAsString(picture);
        log.info(json);
        rabbitTemplate.convertAndSend("ex.picture.dlx", picture.getType(), json);

    }


}
