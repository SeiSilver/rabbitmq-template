package com.producerservice.service.producer_topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producerservice.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureTopicProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureTopicProducer.class);

    public void sendMessage(Picture picture) throws JsonProcessingException {

        objectMapper.findAndRegisterModules();

        String sb = picture.getSource() + ".";
        if (picture.getSize() > 4000) {
            sb += "large";
        } else {
            sb += "small";
        }
        sb += "." + picture.getType();

        var json = objectMapper.writeValueAsString(picture);
        log.info(json);
        rabbitTemplate.convertAndSend("x.topic.picture", sb, json);

    }

}
