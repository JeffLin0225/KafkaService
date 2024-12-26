package com.kafkaService.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        if(message.equals("good")){
            kafkaTemplate.send("test-topic", message);
        }else{
            kafkaTemplate.send("my-new-topic", message);
        }
        return "Message sent to Kafka topic: " + message;
    }
}


