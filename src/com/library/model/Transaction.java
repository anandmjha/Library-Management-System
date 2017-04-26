package com.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.library.dao.BookDaoImpl;
import com.library.dao.TransactionDao;

public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String accessionNo;
	private String transactionId;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private int fineAmount;
	private String status;
	private String title;
	private String author;
	
	TransactionDao ts= new BookDaoImpl();
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String memberId, String accessionNo,
			String transactionId, Date issueDate, Date dueDate,
			Date returnDate, int fineAmount, String status) {
		super();
		this.memberId = memberId;
		this.accessionNo = accessionNo;
		this.transactionId = transactionId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
		this.status = status;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
		System.out.println("In tx setMemberId  "+memberId);
	}

	public String getAccessionNo() {
		return accessionNo;
	}

	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public ArrayList<Transaction> getRetrieveBorrowedBooks() {
		
		return ts.retrieveBorrowedBooks(this.memberId);
	}
	
	
	@Override
	public String toString() {
		return "Transaction [memberId=" + memberId + ", accessionNo="
				+ accessionNo + ", transactionId=" + transactionId
				+ ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", returnDate=" + returnDate + ", fineAmount=" + fineAmount
				+ ", status=" + status + ", title=" + title + ", author="
				+ author + "]";
	}
	
}
