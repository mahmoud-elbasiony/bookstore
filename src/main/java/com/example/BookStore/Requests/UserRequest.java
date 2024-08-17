package com.example.BookStore.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserRequest {


    private String fullName;

    private String email;

    private String password;

    private Date createdAt;

    private Date updatedAt;


}

