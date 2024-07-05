package com.example.FBJV24001115synergy7firbinfudch6.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "your_topic_name", groupId = "your_group_id")
    public void listen(ConsumerRecord<String, String> record) {
        messages.add(record.value());
    }

    public List<String> getMessages() {
        return messages;
    }
}
