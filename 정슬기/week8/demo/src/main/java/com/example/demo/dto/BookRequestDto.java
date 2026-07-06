package com.example.demo.dto;
import com.example.demo.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    @NotBlank(message = "책의 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "저자를 입력해주세요")
    private String author;

    @NotNull(message = "가격을 입력해주세요.")
    @PositiveOrZero(message = "가격은 최소 0원이어야 합니다.")
    private Integer price;

    public Book toEntity(){
        return new Book(title, author, price);
    }
}
