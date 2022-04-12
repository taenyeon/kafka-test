package com.example.springtest.controller;

import com.example.springtest.service.TestProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestProducerService testProducerService;

    public TestController(TestProducerService testProducerService) {
        this.testProducerService = testProducerService;
    }
    @PostMapping(value = "/sendMessage")
    public void sendMessage(String message){
        testProducerService.sendMessage(message);
    }
}
