package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public String  sayHello(String name) {
        return "Service 계층에서 생성한 메시지 : Hello," + name;
    }
}
