package com.example.BookStore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.Entities.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	

}
