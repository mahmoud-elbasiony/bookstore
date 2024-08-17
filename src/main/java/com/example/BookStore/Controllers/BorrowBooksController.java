package com.example.BookStore.Controllers;

import com.example.BookStore.Mappers.BorrowingBooksMapper;
import com.example.BookStore.Responses.BorrowingBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookStore.Services.BookService;
import com.example.BookStore.Services.BorrowBookService;
import com.example.BookStore.Services.PatronService;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class BorrowBooksController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private PatronService patronService;
	@Autowired
	private BorrowBookService borrowBookService;
	
	@GetMapping("borrowingBooks")
	public ResponseEntity<Iterable<BorrowingBooksResponse>> index(){
		return  ResponseEntity.ok(this.borrowBookService.findAll()
				.stream()
				.map(borrowingBook -> BorrowingBooksMapper.ToResponse(borrowingBook))
				.collect(Collectors.toList())
		);
	}

	@GetMapping("borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<Iterable<BorrowingBooksResponse>> show(@PathVariable Integer bookId, @PathVariable Integer patronId){
		return  ResponseEntity.ok(this.borrowBookService.findAllByBookAndPatron(bookId,patronId)
				.stream()
				.map(borrowingBook -> BorrowingBooksMapper.ToResponse(borrowingBook))
				.collect(Collectors.toList())
		);
	}
	@PostMapping("borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<BorrowingBooksResponse> store(@PathVariable Integer bookId, @PathVariable Integer patronId){
		BorrowingBooksResponse borrowingBooksResponse=BorrowingBooksMapper.ToResponse(this.borrowBookService.save(bookId,patronId));
		return ResponseEntity.ok(borrowingBooksResponse);

	}
	
	@PutMapping("return/{bookId}/patron/{patronId}")
	public ResponseEntity<BorrowingBooksResponse> update(@PathVariable Integer bookId,@PathVariable Integer patronId){
		BorrowingBooksResponse borrowingBooksResponse=BorrowingBooksMapper.ToResponse(this.borrowBookService.update(bookId,patronId));
		return ResponseEntity.ok(borrowingBooksResponse);

	}



}
