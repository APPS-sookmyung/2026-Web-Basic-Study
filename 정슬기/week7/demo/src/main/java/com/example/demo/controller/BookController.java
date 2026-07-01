package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService
            bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book join(@RequestBody Book book){
        return bookService.join(book);
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findBooks();
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id){
        return bookService.findOne(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "삭제 완료: id=" + id;
    }
}
