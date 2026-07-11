package com.example.todo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=
            GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "마감일을 기입해주세요.")
    private String date;

    @NotEmpty(message = "할 일을 기입해주세요.")
    @Size(max = 150, message = "150자 이내로 기입해주세요.")
    private String content;

    public Todo(){}
    public Todo(String date, String content) {
        this.date=date;
        this.content = content;
    }

    public Long getId() { return id;}
    public String getDate() { return date; }
    public String getContent() { return content; }
    public void setDate(String date) {
        this.date = date;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
