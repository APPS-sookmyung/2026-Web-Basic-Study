package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book join(Book book){
        return bookRepository.save(book);
    }

    public List<Book>findBooks(){
        return bookRepository.findAll();
    }

    public Book findOne(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("책이 없습니다. id="+id));
    }

    public Book update(Long id, Book newData){
        Book book = findOne(id);
        book.setTitle(newData.getTitle());
        book.setAuthor(newData.getAuthor());
        book.setPrice(newData.getPrice());
        return bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
