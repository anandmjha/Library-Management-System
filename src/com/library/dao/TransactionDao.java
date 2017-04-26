package com.library.dao;

import java.util.ArrayList;

import com.library.model.Transaction;

public interface TransactionDao {

	boolean spawnTransaction(Transaction transaction);

	ArrayList<Transaction> retrieveAll();

	ArrayList<Transaction> retrieveBorrowedBooks(String memberId);

	ArrayList<Transaction> retrieveAccessionNos();

	int returnBook(String accessionNo);

	int countBorrowedBooks(String memberId);
}
