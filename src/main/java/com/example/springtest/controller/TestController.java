package com.example.springtest.controller;

import com.example.springtest.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping(value = "/sendMessage")
    public void sendMessage(String message) throws InterruptedException {
        int i = 0;
        while (i<1000){
            testService.sendMessage(message);
            Thread.sleep(10);
            i++;
        }
    }

}
