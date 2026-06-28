package com.example.todo.controller;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;
    public TodoController(
            TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo join(
            @RequestBody Todo todo) {
        return todoService.join(todo);
    }

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findTodo();
    }


    @GetMapping("/{id}")
    public Todo findOne(@PathVariable Long id){
        return todoService.findOne(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id,
                       @RequestBody Todo todo){
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        todoService.delete(id);
        return "삭제완료: id="+ id;
    }
}
