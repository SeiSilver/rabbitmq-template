//package com.consumerservice.service.consumer_dlx;
//
//import com.consumerservice.entity.Picture;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rabbitmq.client.Channel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
//import java.io.IOException;
//
////@Service
//public class PictureDlxConsumer_manual {
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    private Logger log = LoggerFactory.getLogger(PictureDlxConsumer_manual.class);
//
//    @RabbitListener(queues = "dlx.picture.queue")
//    public void listen(Message message, Channel channel) throws IOException {
//        objectMapper.findAndRegisterModules();
//        var picture = objectMapper.readValue(message.getBody(), Picture.class);
//
//        if (picture.getSize() > 9000) {
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        }
//
//        log.info("On image : {}", picture.toString());
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//    }
//
//}
