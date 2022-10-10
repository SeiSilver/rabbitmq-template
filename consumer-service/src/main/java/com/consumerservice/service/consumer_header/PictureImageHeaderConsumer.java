package com.consumerservice.service.consumer_header;

import com.consumerservice.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureImageHeaderConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureImageHeaderConsumer.class);

    @RabbitListener(queues = "q.header.image")
    public void listen(String message) throws JsonProcessingException {
        var picture = objectMapper.readValue(message, Picture.class);
        log.info("On image : {}", picture.toString());
    }

}
