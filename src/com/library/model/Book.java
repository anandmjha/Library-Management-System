package com.library.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.library.dao.BookDao;
import com.library.dao.BookDaoImpl;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accessionNo;
	private String title;
	private String author;
	private String status;
	BookDao bd = new BookDaoImpl();
	
	public Book() {
		System.out.println("In Book dflt..");
		// TODO Auto-generated constructor stub
	}

	public Book(String accessionNo, String title, String author, String status) {
		super();
		this.accessionNo = accessionNo;
		this.title = title;
		this.author = author;
		this.status = status;
	}

	public String getAccessionNo() {
		return accessionNo;
	}

	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;

		System.out.println("setTitle  " + title);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int addBook() {

		return (bd.addBook(this));

	}

	public boolean deleteBook() {

		return (bd.deleteBook(this.accessionNo));

	}

	public boolean updateBook() {

		return (bd.updateBook(this));

	}

	public Book viewBook() {

		return bd.viewBook(this.accessionNo);
	}

	public ArrayList<Book> getAllBooks() {

		return bd.viewAll();
	}

	public ArrayList<Book> getBooksByAccessionNo() {

		return new BookDaoImpl().viewByAccessionNo(accessionNo);
	}

	public ArrayList<Book> getBooksByTitle() {

		return new BookDaoImpl().viewByTitle(title);
	}

	public ArrayList<Book> getBooksByAuthor() {

		return new BookDaoImpl().viewByAuthor(author);
	}
	
	@Override
	public String toString() {
		return "Book [accessionNo=" + accessionNo + ", title=" + title
				+ ", author=" + author + ", status=" + status + "]";
	}

}
