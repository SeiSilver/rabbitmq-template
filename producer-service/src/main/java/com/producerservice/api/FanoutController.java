package com.producerservice.api;

import com.producerservice.entity.Employee;
import com.producerservice.service.producer_fanout.HrFanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("ex")
public class FanoutController {

    @Autowired
    private HrFanoutProducer hrFanoutProducer;

    @GetMapping("fanout")
    public String callSendMessage() {

        for (int i = 0; i < 5; i++) {
            var e = new Employee("emp " + i, "Employee " + i, new Date());
            hrFanoutProducer.sendMessage(e);
        }

        return "Da gui message thanh cong";
    }

}
