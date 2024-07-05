package com.example.FBJV24001115synergy7firbinfudch6.controller;

import com.example.FBJV24001115synergy7firbinfudch6.model.dto.KafkaMessageDTO;
import com.example.FBJV24001115synergy7firbinfudch6.service.KafkaConsumerService;
import com.example.FBJV24001115synergy7firbinfudch6.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/messages")
    public ResponseEntity<List<String>> getMessages() {
        return ResponseEntity.ok(kafkaConsumerService.getMessages());
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody KafkaMessageDTO request) {
        kafkaProducerService.sendMessage(request.getTopic(), request.getMessage());
        return ResponseEntity.ok("Message published to topic " + request.getTopic());
    }
}
