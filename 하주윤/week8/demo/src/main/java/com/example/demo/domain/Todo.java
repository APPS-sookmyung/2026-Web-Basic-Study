package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 할 일 내용에 대한 유효성 검증
    @NotBlank(message = "할 일 내용은 비어있을 수 없습니다.")
    @Size(min = 2, max = 100, message = "할 일은 2자 이상 100자 이하로 작성해주세요.")
    private String task;
    private boolean finished;

    public Todo(){}

    public Todo(String task, boolean finished) {
        this.task = task;
        this.finished = finished;
    }
}
