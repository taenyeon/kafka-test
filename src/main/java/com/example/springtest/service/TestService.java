package com.example.springtest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestService {
    private int foo = 1;
    private int bar = 1;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("test-topic",message);
    }

    @KafkaListener(topics = "test-topic",groupId = "foo")
    public void fooListen(List<String> message) throws InterruptedException {
        Thread.sleep(1000);
        foo++;
      log.info("(foo) message = {} , foo = {}",message, foo);
    }

    @KafkaListener(topics = "test-topic",groupId = "bar")
    public void barListen(String message) {
        bar++;
        log.info("(bar) message = {} ,  bar = {}",message,bar);
    }

}
