package com.example.BookStore.Mappers;

import com.example.BookStore.Entities.Book;
import com.example.BookStore.Entities.User;
import com.example.BookStore.Requests.RegisterUserRequest;
import com.example.BookStore.Responses.BookResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class UserMapper {
    private final PasswordEncoder passwordEncoder;
 public  User ToEntity(RegisterUserRequest registerUserRequest){
        return User.builder()
                .fullName(registerUserRequest.getFullName())
                .email(registerUserRequest.getEmail())
                .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                .build();

    }

    public  BookResponse ToResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .name(book.getName())
                .publicationDate(book.getPublicationDate())
                .build();

    }
}
