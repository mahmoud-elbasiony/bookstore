package com.example.BookStore.Services;

import com.example.BookStore.Exceptions.BookBusinessLogicException;
import com.example.BookStore.Mappers.BookMapper;
import com.example.BookStore.Responses.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookStore.Entities.Book;
import com.example.BookStore.Exceptions.BookNotFoundException;
import com.example.BookStore.Repositories.BookRepository ;

import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookService {
	@Autowired
	@Lazy
	public BookService(BorrowBookService borrowBookService ,PatronService patronService,BookRepository bookRepository){
		this.borrowBookService=borrowBookService;
		this.patronService=patronService;
		this.bookRepository=bookRepository;

	}
//	@Autowired
	private BookRepository bookRepository;

//	@Autowired
	private PatronService patronService;


	private BorrowBookService borrowBookService;
	public Book findById(int id) {
		return this.getBookRepository().findById(id).orElseThrow(()->new BookNotFoundException("book not found"));
	}

	public Book save(Book book) {
		return this.bookRepository.save(book);
		
	}
	
	public Book update(Book oldBook,Book book) {
		oldBook.setAuthor(book.getAuthor());
		oldBook.setName(book.getName());
		oldBook.setIsbn(book.getIsbn());
		oldBook.setPublicationDate(book.getPublicationDate());

		return this.bookRepository.save(oldBook);
		
	}

	public void deleteById(Integer id) {
		Book oldbook=this.findById(id);
		if(this.borrowBookService.findAllByBook(oldbook).size()>0)
			throw new BookBusinessLogicException("Cannot delete books borrowed by patrons before");
		this.bookRepository.delete(oldbook);
		
	}

	public Iterable<BookResponse> findAll() {
		
		return this.bookRepository.findAll().stream().map(book -> BookMapper.ToResponse(book)).collect(Collectors.toList());
	}

}
