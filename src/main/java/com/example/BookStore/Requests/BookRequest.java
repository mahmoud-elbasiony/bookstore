package com.example.BookStore.Requests;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookRequest {


	private int id;

	@NonNull
	@Size(min=2,max=40,message = "Book Title must be between 2 and 40")
	private String name;

	@NonNull
	@Size(min=2,max=40,message = "author Name must be between 2 and 20")
	private String author;

	@NotNull(message = "date must not be null")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date publicationDate;

	@Size(min=2,max=40)
	@NonNull
	@JsonAlias(value = "ISBN")
	@NotEmpty(message = "ISBN is required")
	private String isbn;

//	public List<Integer> borrowingBookIds;

		
		
}