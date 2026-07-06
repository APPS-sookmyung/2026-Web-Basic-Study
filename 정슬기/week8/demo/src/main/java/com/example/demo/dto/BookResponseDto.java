package com.example.demo.dto;

import com.example.demo.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Integer price;

    public static BookResponseDto from(Book book){
        return new BookResponseDto(
                book.getId(), book.getTitle(), book.getAuthor(), book.getPrice()
        );
    }
}
