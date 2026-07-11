package com.example.todo.dto;

import com.example.todo.domain.Todo;
import lombok.Data;

@Data
public class TodoResponseDto {
    private Long id;
    private String date;
    private String content;

    public TodoResponseDto(Long id, String date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public static TodoResponseDto from(Todo todo){
        return new TodoResponseDto(
                todo.getId(), todo.getDate(), todo.getContent()
        );

    }
}
