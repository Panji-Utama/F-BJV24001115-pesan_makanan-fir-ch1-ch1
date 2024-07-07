package com.ch7.notification_service.listener;
import com.ch7.notification_service.handler.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumerListener {

    @Autowired
    private WebSocketHandler webSocketHandler;

    @KafkaListener(topics = "orders", groupId = "group_id")
    public void listen(String message) throws IOException {
        webSocketHandler.broadcast(message);
    }
}