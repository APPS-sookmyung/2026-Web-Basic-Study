package com.example.todo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=
            GenerationType.IDENTITY)
    private Long id;
    private String date;
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
