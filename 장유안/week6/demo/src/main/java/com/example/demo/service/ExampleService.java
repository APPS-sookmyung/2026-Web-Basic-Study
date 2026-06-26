package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ExampleService {
    public String sayHello(String name) {
        return "Service 계층에서 생성한 메세지 : Hello," + name;
    }
}
