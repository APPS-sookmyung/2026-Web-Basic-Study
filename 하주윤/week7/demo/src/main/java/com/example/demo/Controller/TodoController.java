package com.example.demo.Controller;

import com.example.demo.Service.TodoService;
import com.example.demo.domain.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping("/todos")
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/todos/{id}")
    public Todo findOne(@PathVariable Long id) {
        return todoService.findOne(id);
    }

    @PutMapping("/todos/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.update(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }
}
