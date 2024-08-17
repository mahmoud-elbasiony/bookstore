package com.example.BookStore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.Entities.Patron;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Integer>{

}
