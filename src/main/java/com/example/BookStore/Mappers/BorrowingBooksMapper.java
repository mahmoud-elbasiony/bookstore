package com.example.BookStore.Mappers;


import com.example.BookStore.Entities.BorrowingBooks;
import com.example.BookStore.Requests.BorrowingBooksRequest;
import com.example.BookStore.Responses.BorrowingBooksResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@Component
public class BorrowingBooksMapper {


    public static BorrowingBooks ToEntity(BorrowingBooksRequest borrowingBooksRequest){
        return BorrowingBooks.builder()
                .id(borrowingBooksRequest.getId())
                .book(
                        BookMapper.ToEntity(borrowingBooksRequest.getBook())
                )
                .patron(
                        PatronMapper.ToEntity(borrowingBooksRequest.getPatron())
                )
                .borrowingDate(borrowingBooksRequest.getBorrowingDate())
                .returnDate(borrowingBooksRequest.getReturnDate())
                .build();

    }

    public static BorrowingBooksResponse ToResponse(BorrowingBooks borrowingBooks){
        return BorrowingBooksResponse.builder()
                .id(borrowingBooks.getId())
                .book(
                        BookMapper.ToResponse(borrowingBooks.getBook())
                )
                .patron(
                        PatronMapper.ToResponse(borrowingBooks.getPatron())
                )
                .borrowingDate(borrowingBooks.getBorrowingDate())
                .returnDate(borrowingBooks.getReturnDate())
                .build();


    }

}
