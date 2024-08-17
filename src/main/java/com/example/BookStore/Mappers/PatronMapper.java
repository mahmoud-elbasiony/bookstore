package com.example.BookStore.Mappers;


import com.example.BookStore.Entities.Patron;
import com.example.BookStore.Requests.PatronRequest;
import com.example.BookStore.Responses.PatronResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@Component
public class PatronMapper {


    public static Patron ToEntity(PatronRequest patronRequest){
        return Patron.builder()
                .id(patronRequest.getId())
                .email(patronRequest.getEmail())
                .name(patronRequest.getName())
                //.borrowingBooks(patronRequest.getBorrowingBooks())
                .build();

    }

    public static PatronResponse ToResponse(Patron patron){
        return PatronResponse.builder()
                .id(patron.getId())
                .email(patron.getEmail())
                .name(patron.getName())
                //.borrowingBooks(patron.getBorrowingBooks())
                .build();


    }

}
