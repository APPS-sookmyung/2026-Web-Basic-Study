package com.example.demo.Controller;

import com.example.demo.Service.TodoService;
import com.example.demo.domain.Todo;
import com.example.demo.DTO.TodoResponseDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoResponseDto> create(@RequestBody Todo todo) {
        Todo savedTodo = todoService.create(todo);
        // 엔티티를 DTO로 변환하여 응답
        return ResponseEntity.ok().body(TodoResponseDto.from(savedTodo));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        List<Todo> todoList = todoService.findAll();
        // 리스트 내의 모든 엔티티를 DTO로 변환
        return ResponseEntity.ok().body(
                todoList.stream()
                        .map(TodoResponseDto::from)
                        .collect(Collectors.toList())
        );
    }

    // 특정 ID의 할 일 상세 조회
    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoResponseDto> findOne(@PathVariable Long id) {
        Todo todo = todoService.findOne(id);
        return ResponseEntity.ok().body(TodoResponseDto.from(todo));
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable Long id, @RequestBody Todo todo){
        Todo updatedTodo = todoService.update(id, todo);
        return ResponseEntity.ok().body(TodoResponseDto.from(updatedTodo));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        todoService.delete(id);
        // 삭제 성공 시 데이터 없이 204 No Content 상태 코드 반환
        return ResponseEntity.noContent().build();
    }
}
