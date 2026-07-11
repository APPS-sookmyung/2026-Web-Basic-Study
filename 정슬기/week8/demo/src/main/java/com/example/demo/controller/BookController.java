package com.example.demo.controller;

import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import jakarta.validation.Valid;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponseDto join(@Valid @RequestBody BookRequestDto requestDto){
        Book savedBook = bookService.join(requestDto.toEntity());
        return BookResponseDto.from(savedBook);
    }

    @GetMapping
    public List<BookResponseDto> findAll(){
        return bookService.findBooks()
                .stream()
                .map(BookResponseDto::from)
                .toList();
    }

    @GetMapping("/{id}")
    public BookResponseDto findOne(@PathVariable Long id){
        Book book = bookService.findOne(id);
        return BookResponseDto.from(book);
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id, @Valid @RequestBody BookRequestDto requestDto){
        Book updateBook = bookService.update(id, requestDto.toEntity());
        return BookResponseDto.from(updateBook);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "삭제 완료: id=" + id;
    }
}
