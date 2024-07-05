package com.ch7.Gateway.controller;

import com.ch7.Gateway.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gateway")
public class GatewayController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody String message) {
        kafkaProducerService.sendMessage("orders", message);
        return "Message sent to Kafka";
    }
}
