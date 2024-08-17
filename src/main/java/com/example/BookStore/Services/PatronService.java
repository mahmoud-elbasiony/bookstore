package com.example.BookStore.Services;

import java.util.List;

import com.example.BookStore.Exceptions.BorrowBookException;
import com.example.BookStore.Exceptions.PatronBusinessLogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.BookStore.Entities.Patron;
import com.example.BookStore.Exceptions.BookNotFoundException;
import com.example.BookStore.Repositories.PatronRepository;

import jakarta.validation.Valid;

@Slf4j
@Service
public class PatronService {



@Autowired
@Lazy
	public PatronService(PatronRepository patronRepository) {
		this.patronRepository = patronRepository;
	}


	private PatronRepository patronRepository;

	public List<Patron> findAll() {
		return this.patronRepository.findAll();
	}

	public Patron findById(int id) {
		return this.patronRepository.findById(id).orElseThrow(()->new BookNotFoundException("book not found"));
	}

	public Patron save(Patron patron) {
		return this.patronRepository.save(patron);
		
	}

	public Patron update(Integer id, @Valid Patron patron) {
		Patron oldPatron=this.findById(id);

		if(patron.getName()!=null)
			oldPatron.setName(patron.getName());
		if(patron.getEmail()!=null)
			oldPatron.setEmail(patron.getEmail());
		return this.patronRepository.save(oldPatron);

	}

	public void delete(int id) {
		Patron oldpatron=this.findById(id);
		if(oldpatron.getBorrowingBooks().size()>0)
			throw new PatronBusinessLogicException("cannot delete patron while there is books borrowed By him");
		this.patronRepository.delete(oldpatron);
		
	}



//	public List<BorrowingBooks> getPatronBooks(Integer patronId, Integer bookId) {
//		Patron oldPatron=this.findById(patronId);
//		List<BorrowingBooks> borrowingBook=oldPatron.getBorrowingBooks().stream().map((bk)->bk.getId()==bookId)).toList();
//		return borrowingBooks;
//	}

//	public Book saveAddPatronBooks(Integer patronId, Integer bookId) {
//		Book book=this.bookService.findById(bookId);
//
//		Patron oldPatron=this.findById(patronId);
//		
//		oldPatron.getBooks().add(book);
//		oldPatron=this.save(oldPatron);
//		return book;
//	}

//	public Patron deletePatronBook(Integer patronId, Integer bookId) {
//		Patron oldPatron=this.findById(patronId);
//		oldPatron.getBooks().stream().filter((bk)->bk.getId()==bookId).findFirst().orElseThrow(()->new BookNotFoundException("Book Not Found"));
//		oldPatron.getBooks().removeIf((bk)->bk.getId()==bookId);
//		return this.save(oldPatron);
//		
//	}
	
	

}
