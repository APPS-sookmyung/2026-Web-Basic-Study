package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoRequestDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;


    public TodoService(
            TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto join(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto.getDate(), requestDto.getContent());
        Todo savedTodo = todoRepository.save(todo);
        return TodoResponseDto.from(savedTodo);
    }

    public List<Todo> findTodo() {return todoRepository.findAll();
    }

    public Todo findOne(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "등록된 일정이 없습니다. id="+ id));
    }
    public Todo update(Long id, Todo newData){
        Todo todo = findOne(id);
        todo.setDate(newData.getDate());
        todo.setContent(newData.getContent());
        return todoRepository.save(todo);
    }
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
