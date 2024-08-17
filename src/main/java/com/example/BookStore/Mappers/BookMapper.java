package com.example.BookStore.Mappers;


import com.example.BookStore.Entities.Book;
import com.example.BookStore.Requests.BookRequest;
import com.example.BookStore.Responses.BookResponse;
import org.springframework.stereotype.Component;



@Component
public class BookMapper {


    public static Book ToEntity(BookRequest bookRequest){
        return Book.builder()
                .author(bookRequest.getAuthor())
                .isbn(bookRequest.getIsbn())
                .name(bookRequest.getName())
                .publicationDate(bookRequest.getPublicationDate())
                .build();

    }

    public static BookResponse ToResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .name(book.getName())
                .publicationDate(book.getPublicationDate())
                .build();

    }

}
