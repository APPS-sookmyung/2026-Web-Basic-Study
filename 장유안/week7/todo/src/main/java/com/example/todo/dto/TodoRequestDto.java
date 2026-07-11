package com.example.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoRequestDto {
    @NotEmpty(message = "마감일을 기입해주세요.")
    private String date;

    @NotEmpty(message = "할 일을 기입해주세요.")
    @Size(max = 150, message = "150자 이내로 기입해주세요.")
    private String content;
}
