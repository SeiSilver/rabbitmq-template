//package com.consumerservice.service.consumer_dlx;
//
//import com.consumerservice.entity.Picture;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.AmqpRejectAndDontRequeueException;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
////@Service
//public class PictureDlxConsumer {
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    private Logger log = LoggerFactory.getLogger(PictureDlxConsumer.class);
//
//    @RabbitListener(queues = "dlx.picture.queue")
//    public void listen(String message) throws JsonProcessingException {
//        objectMapper.findAndRegisterModules();
//        var picture = objectMapper.readValue(message, Picture.class);
//
//        if (picture.getSize() > 9000) {
//            throw new AmqpRejectAndDontRequeueException("Picture size too large: " + picture);
//        }
//
//        log.info("On image : {}", picture.toString());
//
//    }
//
//}
