package com.example.BookStore.Entities;

import java.util.Date;


import jakarta.persistence.*;
import lombok.*;


import jakarta.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
@Builder
public class BorrowingBooks {
	



	@Column(name="ID")
	  @Id
	  @GeneratedValue(strategy=GenerationType.SEQUENCE)
	  private Integer id;

	@JoinColumn(name="PATRON_ID")
	  @NotNull
	  @ManyToOne
	  private Patron patron;

	@JoinColumn(name="BOOK_ID")
	  @ManyToOne
	  @NotNull
	  private Book book;

	@Column(name="BORROWING_DATE")
	@Temporal(TemporalType.DATE)
	  private Date borrowingDate;

	@Column(name="RETURN_DATE")
	@Temporal(TemporalType.DATE)
	  private Date returnDate;


}
