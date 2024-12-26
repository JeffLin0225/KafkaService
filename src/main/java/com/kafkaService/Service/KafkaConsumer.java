package com.kafkaService.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    // 聽取 'my-new-topic' topic 的消息
    @KafkaListener(topics = "my-new-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message from my-new-topic: " + message);
    }

    // 聽取 'test-topic' topic 的消息
    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listenn(String message) {
        System.out.println("Received message from test-topic: " + message);
    }
}
