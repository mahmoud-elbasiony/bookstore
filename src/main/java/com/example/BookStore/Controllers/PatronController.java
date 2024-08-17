package com.example.BookStore.Controllers;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.example.BookStore.Mappers.BorrowingBooksMapper;
import com.example.BookStore.Mappers.PatronMapper;
import com.example.BookStore.Requests.PatronRequest;
import com.example.BookStore.Responses.BorrowingBooksResponse;
import com.example.BookStore.Responses.PatronResponse;
import com.example.BookStore.Services.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.BookStore.Entities.Patron;
import com.example.BookStore.Services.BookService;
import com.example.BookStore.Services.PatronService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/patrons")
public class PatronController {

	@Autowired
	private PatronService patronService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BorrowBookService borrowBookService;


	
	@GetMapping
	public @ResponseBody List<PatronResponse> index(){
		return this.patronService.findAll().stream().map(patron -> PatronMapper.ToResponse(patron)).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatronResponse> show(@PathVariable Integer id){
		Patron oldpatron=this.patronService.findById(id);		
		return ResponseEntity.ok(PatronMapper.ToResponse(oldpatron));

	}
	


	@PostMapping
	public ResponseEntity<PatronResponse> store(@Valid @RequestBody PatronRequest patronRequest){
		
		Patron patron=this.patronService.save(PatronMapper.ToEntity(patronRequest));
		URI loction=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(patron.getId()).toUri();
		return ResponseEntity.created(loction).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PatronResponse> update(@PathVariable Integer id, @Valid @RequestBody PatronRequest patronRequest){
		Patron patron=this.patronService.update(id,PatronMapper.ToEntity(patronRequest));

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PatronResponse> delete(@PathVariable Integer id){
		this.patronService.delete(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/books")
	public @ResponseBody ResponseEntity<List<BorrowingBooksResponse>> getPatronBooks(@PathVariable Integer id){
		List<BorrowingBooksResponse> borrowingBooksResponseList=this.borrowBookService.getPatronBooks(id)
				.stream()
				.map(borrowingBook -> BorrowingBooksMapper.ToResponse(borrowingBook))
				.collect(Collectors.toList());
		return ResponseEntity.ok(borrowingBooksResponseList);
	}
//	
//	@GetMapping("/{patronId}/books/{bookId}")
//	public ResponseEntity<Book> showPatronBooks(@PathVariable Integer patronId,@PathVariable Integer bookId){
//		Book book=this.patronService.getPatronBooks(patronId,bookId);
//		return ResponseEntity.ok(book);

//	}
	


//	@PostMapping("/{patronId}/books")
//	public ResponseEntity<Book> storePatronBooks(@PathVariable Integer patronId,@RequestParam Integer bookId){
//		Book book=this.patronService.saveAddPatronBooks(patronId,bookId);
//		URI loction=ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(book.getId()).toUri();
//		return ResponseEntity.created(loction).build();
//	}
//	
//	@DeleteMapping("/{patronId}/books/{bookId}")
//	public ResponseEntity<Patron> deletePatronBook(@PathVariable Integer patronId,@PathVariable Integer bookId){
//		Patron oldpatron=this.patronService.deletePatronBook(patronId,bookId);
//
//		return ResponseEntity.ok().build();
//	}
	


}