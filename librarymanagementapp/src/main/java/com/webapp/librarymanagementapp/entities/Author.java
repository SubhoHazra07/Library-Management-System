package com.webapp.librarymanagementapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Override
	public String toString() {
		return "Author [author=" + author + "]";
	}
	@Id
	@Column(name="name")
	private String author;
	
	public Author() {
		super();
	}

	public Author(String author) {
		super();
		this.author = author;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}
	
}
