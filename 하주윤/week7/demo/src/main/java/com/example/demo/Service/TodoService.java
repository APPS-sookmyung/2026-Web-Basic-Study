package com.example.demo.Service;

import com.example.demo.domain.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo findOne(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    public Todo update(Long id, Todo todoInfo){
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTask(todoInfo.getTask());
        todo.setFinished(todoInfo.isFinished());
        return todo;
    }

    public void delete(Long id){todoRepository.deleteById(id);}
}
