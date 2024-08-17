package com.example.BookStore.Responses;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookResponse {
		public int id;
		
		public String name;
		
		public String author;
		
		@JsonFormat(pattern="yyyy-MM-dd")
		public Date publicationDate;
		
		@JsonAlias(value = "ISBN")
		public String isbn;
		
		
//		public List<BorrowingBooks> borrowingBooks;

}