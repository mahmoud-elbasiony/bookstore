package com.example.BookStore.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BorrowingBooksRequest {

	  private Integer id;

	  @NotNull
	  private PatronRequest patron;
	  

	  @NotNull
	  private BookRequest book;

	  @DateTimeFormat
	  private Date borrowingDate;
	  
	  @DateTimeFormat
	  private Date returnDate;


}
