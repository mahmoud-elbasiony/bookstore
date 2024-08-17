package com.example.BookStore.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequest {

    @Email(message = "email is not valid")
    private String email;
    @Size(min = 8,max = 20,message = "password is not valid")
    private String password;
    @Size(min = 8,max = 100,message = "fullName is not valid")
    private String fullName;

}