package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "책의 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "저자를 입력해주세요.")
    private String author;

    @NotNull(message = "가격을 입력해주세요.")
    @PositiveOrZero(message = "가격은 최소 0원이어야 합니다.")
    private Integer price;

    public Book() {}

    public Book(String title, String author, Integer price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author;}
    public Integer getPrice() { return price; }

    public void setTitle(String title) {
        this.title = title;}
    public void setAuthor(String author) {
        this.author = author;}
    public void setPrice(Integer price) {
        this.price = price;}
}
