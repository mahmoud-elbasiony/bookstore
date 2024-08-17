package com.example.BookStore.Controllers;


import java.net.URI;


import com.example.BookStore.Mappers.BookMapper;
import com.example.BookStore.Requests.BookRequest;
import com.example.BookStore.Responses.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.BookStore.Entities.Book;
import com.example.BookStore.Exceptions.BookNotFoundException;
import com.example.BookStore.Services.BookService;
import com.example.BookStore.Services.PatronService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private PatronService patronService;
	
	@GetMapping
	public ResponseEntity<Iterable<BookResponse>> index(){
		return  ResponseEntity.ok(this.bookService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponse> show(@PathVariable Integer id){
		Book oldbook=this.bookService.findById(id);
		return ResponseEntity.ok(BookMapper.ToResponse(oldbook));

	}
	


	@PostMapping
	public ResponseEntity<BookResponse> store(@Valid @RequestBody BookRequest bookRequest){
		System.out.println(bookRequest);
		Book book=this.bookService.save(BookMapper.ToEntity(bookRequest));
		URI loction=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(loction).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookResponse> update(@PathVariable Integer id, @Valid @RequestBody BookRequest bookRequest){

		Book oldbook=this.bookService.getBookRepository().findById(id).orElseThrow(()->new BookNotFoundException("book not found"));

		oldbook=this.bookService.update(oldbook,BookMapper.ToEntity(bookRequest));
			
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BookResponse> delete(@PathVariable Integer id){


		this.bookService.deleteById(id);


		return ResponseEntity.noContent().build();
	}
}
