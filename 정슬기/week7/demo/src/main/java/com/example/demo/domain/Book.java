package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
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
