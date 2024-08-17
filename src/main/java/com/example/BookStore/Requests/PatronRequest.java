package com.example.BookStore.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component // This tells Hibernate to make a table out of this class
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatronRequest {

  private Integer id;

  @NotBlank(message = "name is required")
  @Size(min=2,max=100)
  private String name;

  @NotBlank(message = "email is required")
  @Email
  private String email;

}