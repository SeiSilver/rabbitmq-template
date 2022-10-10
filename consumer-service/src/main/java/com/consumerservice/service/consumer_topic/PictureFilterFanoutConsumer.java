package com.consumerservice.service.consumer_topic;

import com.consumerservice.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureFilterFanoutConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Logger log = LoggerFactory.getLogger(PictureFilterFanoutConsumer.class);

    @RabbitListener(queues = "q.topic.picture.filter")
    public void listen(String message) throws JsonProcessingException {

        var picture = objectMapper.readValue(message, Picture.class);
        log.info("On filter : {}", picture.toString());
    }

}
