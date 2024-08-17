package com.example.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScans({
//		@ComponentScan("com.example.BookStore.Controllers"),
//		@ComponentScan("com.example.BookStore.Entities"),
//		@ComponentScan("com.example.BookStore.Exceptions"),
//		@ComponentScan("com.example.BookStore.Mappers"),
//		@ComponentScan("com.example.BookStore.Repositories"),
//		@ComponentScan("com.example.BookStore.Requests"),
//		@ComponentScan("com.example.BookStore.Responses"),
//		@ComponentScan("com.example.BookStore.Services")
//})
@ComponentScan("com.example")
@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
