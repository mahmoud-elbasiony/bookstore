package com.example.BookStore.Services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.BookStore.Mappers.BorrowingBooksMapper;
import com.example.BookStore.Responses.BorrowingBooksResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookStore.Entities.Book;
import com.example.BookStore.Entities.BorrowingBooks;
import com.example.BookStore.Entities.Patron;
import com.example.BookStore.Exceptions.BorrowBookException;
import com.example.BookStore.Repositories.BorrowBooksRepository;


@Service
public class BorrowBookService {

//	@Autowired
	private BookService bookService;
//	@Autowired
	private PatronService patronService;
	
//	@Autowired
	private BorrowBooksRepository borrowBooksRepository;
	@Autowired
	@Lazy
	public BorrowBookService(BookService bookService, PatronService patronService, BorrowBooksRepository borrowBooksRepository) {
		this.bookService = bookService;
		this.patronService = patronService;
		this.borrowBooksRepository = borrowBooksRepository;
	}




	public BorrowingBooks save(Integer bookId, Integer patronId) {
		
		Book book=this.bookService.findById(bookId);
		Patron patron=this.patronService.findById(patronId);
		BorrowingBooks borrowBook=this.borrowBooksRepository.findByBookAndPatronAndReturnDateIsNull(book,patron);
		if(borrowBook!=null) {
			throw new BorrowBookException("book already borrowed by patron");
		}
		borrowBook=BorrowingBooks.builder()
				.book(book)
				.patron(patron)
				.borrowingDate(new Date())
				.build();

		return this.borrowBooksRepository.save(borrowBook);
	}
	
	public BorrowingBooks update(Integer bookId, Integer patronId) {
		
		Book book=this.bookService.findById(bookId);
		Patron patron=this.patronService.findById(patronId);
		
		BorrowingBooks borrowBook=this.borrowBooksRepository.findByBookAndPatronAndReturnDateIsNull(book,patron);
		if(borrowBook==null) {
			throw new BorrowBookException("book already returned by patron");
		}
		borrowBook.setReturnDate(new Date());
		return  this.borrowBooksRepository.save(borrowBook);
	}

	public List<BorrowingBooks> findAllByBookAndPatron(Integer bookId, Integer patronId) {

		Book book=this.bookService.findById(bookId);
		Patron patron=this.patronService.findById(patronId);

		List<BorrowingBooks>  borrowingBooksList=this.borrowBooksRepository.findAllByBookAndPatron(book,patron);

		return borrowingBooksList;
	}

	public List<BorrowingBooks> findAll() {

		List<BorrowingBooks>  borrowingBooksList=this.borrowBooksRepository.findAll();

		return borrowingBooksList;
	}

	public List<BorrowingBooks> getPatronBooks(Integer patronId) {
		Patron patron=this.patronService.findById(patronId);
		List<BorrowingBooks>  borrowingBooksList=this.borrowBooksRepository.findAllByPatron(patron);

		return borrowingBooksList;
	}

	public List<BorrowingBooks> findAllByBook(Book book) {
		return  this.borrowBooksRepository.findAllByBook(book);
	}
}
