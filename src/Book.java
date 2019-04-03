package com.example.BookStore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@ManyToOne
	//@JsonIgnore
	//@JoinColumn(name = "id")
	
	private Long id;
	private String bookTitle;
	private String bookAuthor;
	private String bookYear;
	private String bookIsbn;
	private String bookPrice;
	
	public Book() {}

	public Book(String bookTitle, String bookAuthor, String bookYear, String bookIsbn, String bookPrice) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookIsbn = bookIsbn;
		this.bookPrice = bookPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookYear() {
		return bookYear;
	}

	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}
	
	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + bookTitle + ", author=" + bookAuthor + ", year=" + bookYear + ", isbn=" + bookIsbn + ", price=" + bookPrice + "]";
	}
}
