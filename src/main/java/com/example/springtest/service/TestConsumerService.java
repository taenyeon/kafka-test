package com.example.springtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestConsumerService {
    @KafkaListener(topics = "test",groupId = "testGroup")
    public void consume(String message){
        log.info("message = {}", message);
    }
}
