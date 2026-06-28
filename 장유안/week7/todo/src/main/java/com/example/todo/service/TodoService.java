package com.example.todo.service;

import com.example.todo.domain.Todo;
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

    public Todo join(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findTodo() {
        return todoRepository.findAll();
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
