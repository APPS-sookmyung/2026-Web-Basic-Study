package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor; // 역직렬화에 필요한 기본 생성자

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    @NotBlank(message = "할 일 내용은 비어있을 수 없습니다.")
    private String task;
    private boolean finished;
}
