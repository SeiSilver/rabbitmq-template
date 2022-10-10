package com.producerservice.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producerservice.entity.Picture;
import com.producerservice.service.producer_header.PictureHeaderProducer;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("ex")
public class HeaderController {

    @Autowired
    private PictureHeaderProducer pictureHeaderProducer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png");

    @GetMapping("header")
    public String callSendMessage() throws JsonProcessingException {

        for (int i = 0; i < 10; i++) {
            var p = new Picture();
            p.setName("Picture " + i);
            p.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
            p.setSource(SOURCES.get(i % SOURCES.size()));
            p.setType(TYPES.get(i % TYPES.size()));

            MessageProperties headers = new MessageProperties();
            headers.setHeader("image-type", p.getType());

            pictureHeaderProducer.sendMessage(p, headers);
        }

        return "Da gui message thanh cong";
    }

}
