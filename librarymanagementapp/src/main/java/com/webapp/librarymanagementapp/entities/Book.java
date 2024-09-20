package com.webapp.librarymanagementapp.entities;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Book {
	
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", book_code=" + book_code + ", book_name=" + book_name + ", author_name=" + author_name
				+ ", added_date=" + added_date + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String book_code, String book_name, String author_name, String added_date) {
		super();
		this.id = id;
		this.book_code = book_code;
		this.book_name = book_name;
		this.author_name = author_name;
		this.added_date = added_date;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="book_id")
	private String book_code;
	
	@Column(name="book_name")
	private String book_name;
	
	@Column(name="book_author")
	private String author_name;
	
	@Column(name="added_date")
	private String added_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
}
