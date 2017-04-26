package com.library.dao;

import java.util.ArrayList;

import com.library.model.Book;

public interface BookDao {

	int addBook(Book book);

	boolean deleteBook(String accessionNo);

	boolean updateBook(Book book);

	boolean checkStatus(String accessionNo);

	boolean changeStatus(String accessionNo, String status);

	Book viewBook(String accessionNo);

	ArrayList<Book> viewAll();

	ArrayList<Book> viewByAuthor(String author);

	ArrayList<Book> viewByAccessionNo(String accessionNo);

	ArrayList<Book> viewByTitle(String title);
	

}
