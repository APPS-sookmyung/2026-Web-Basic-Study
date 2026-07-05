package com.example.demo.DTO;

import com.example.demo.domain.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {
    private final Long id;
    private final String task;
    private final boolean finished;

    public TodoResponseDto(Long id, String task, boolean finished) {
        this.id = id;
        this.task = task;
        this.finished = finished;
    }

    public static TodoResponseDto from(Todo todo){
        return new TodoResponseDto(todo.getId(), todo.getTask(), todo.isFinished());
    }
}
