package com.example.BookStore.Entities;


import java.util.Date;


import jakarta.persistence.*;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PUBLICATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	@Column(name = "ISBN")
	private String isbn;

		
}