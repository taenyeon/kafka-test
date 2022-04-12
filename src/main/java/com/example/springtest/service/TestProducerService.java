package com.example.springtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public TestProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
      log.info("send = {}",message);
      kafkaTemplate.send("test",message);
    }
}
