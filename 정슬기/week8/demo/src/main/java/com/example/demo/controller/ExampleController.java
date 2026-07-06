package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController{

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello3/{name}")
    public String hello3(@PathVariable("name") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello4")
    public String hello4(@RequestParam String name) {
        return exampleService.sayHello(name);
    }
}
