package com.example.BookStore.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class Patron {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name="ID")
  private Integer id;


  @Column(name="NAME")
  @Size(min=2,max=100)
  private String name;

  @NotNull(message = "email is required")
  @Email
  @Column(name="EMAIL")
  private String email;

  @OneToMany(mappedBy = "patron")
  private List<BorrowingBooks> borrowingBooks;


}