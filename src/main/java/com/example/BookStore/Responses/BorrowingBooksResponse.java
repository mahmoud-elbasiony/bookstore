package com.example.BookStore.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class BorrowingBooksResponse {
	

	  private Integer id;
	  
	  
	  private PatronResponse patron;
	  
	  private BookResponse book;
	  
	  
	  
	  @DateTimeFormat private Date borrowingDate;
	  
	  @DateTimeFormat
	  private Date returnDate;


}
