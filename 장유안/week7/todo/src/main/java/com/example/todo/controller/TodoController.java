package com.example.todo.controller;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoRequestDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;
    private Object requestDto;

    public TodoController(
            TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<?> join(
            @Valid @RequestBody TodoRequestDto requestDto, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        TodoResponseDto responseDto = todoService.join(requestDto);
        
        return ResponseEntity.ok(responseDto);
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
