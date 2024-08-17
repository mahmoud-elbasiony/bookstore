package com.example.BookStore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.Entities.Book;
import com.example.BookStore.Entities.BorrowingBooks;
import com.example.BookStore.Entities.Patron;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorrowBooksRepository extends JpaRepository<BorrowingBooks, Integer>{
				   
	BorrowingBooks findByBookAndPatronAndReturnDateIsNull(Book book, Patron patron);

	List <BorrowingBooks> findAllByBookAndPatron(Book book, Patron patron);

	List<BorrowingBooks> findAllByPatron(Patron patron);

    List<BorrowingBooks> findAllByBook(Book book);
}
