package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.BookDao;
import com.library.dao.BookDaoImpl;
import com.library.dao.MemberDao;
import com.library.dao.MemberDaoImpl;
import com.library.dao.TransactionDao;
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Transaction;

/**
 * Servlet implementation class BookController
 */
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDao md;
	BookDao bd;
	Member mm;
	Book bb;
	TransactionDao td;
	int staffLimit;
	int studentLimit;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		md = new MemberDaoImpl();
		bd = new BookDaoImpl();
		td = new BookDaoImpl();
		bb = new Book();
		mm = new Member();
		staffLimit = Integer.parseInt(getInitParameter("staffLimit"));
		studentLimit = Integer.parseInt(getInitParameter("studentLimit"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession hs = request.getSession();

		if (request.getParameter("action").equals("Add")) {
			String accessionNo = request.getParameter("accessionNo");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String Sucessful = "Book Added Sucessfully";
			String Duplicate = "Book Already Exist";
			String Unsucessful = "Something Went Terribly Wrong";
			bb.setAccessionNo(accessionNo);
			bb.setTitle(title);
			bb.setAuthor(author);
			bb.setStatus("Available");
			int bookAdded = bb.addBook();
			if (bookAdded == 1) {
				rd = request.getRequestDispatcher("addbook.jsp");
				request.setAttribute("msg", Sucessful);
				rd.forward(request, response);
			} else if (bookAdded == 2) {
				rd = request.getRequestDispatcher("addbook.jsp");
				request.setAttribute("msg", Duplicate);
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("addbook.jsp");
				request.setAttribute("msg", Unsucessful);
				rd.forward(request, response);
			}

		} else if (request.getParameter("action").equals("DeleteBook")) {
			String accessionNo = request.getParameter("accessionNo");
			System.out.println("acession no" + accessionNo);
			String Sucessful = "Book Deleted Sucessfully";
			String Unsucessful = "Something Went Terribly Wrong";
			bb.setAccessionNo(accessionNo);
			if (bb.deleteBook()) {
				rd = request.getRequestDispatcher("deletebook.jsp");
				request.setAttribute("msg", Sucessful);
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("deletebook.jsp");
				request.setAttribute("msg", Unsucessful);
				rd.forward(request, response);
			}

		} else if (request.getParameter("action").equals("Update")) {
			System.out.println("hello");
			String accessionNo = request.getParameter("accessionNo");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String status = request.getParameter("status");
			String Sucessful = "Book Deleted Sucessfully";
			String Unsucessful = "Something Went Terribly Wrong";
			bb.setAccessionNo(accessionNo);
			bb.setTitle(title);
			bb.setAuthor(author);
			bb.setStatus(status);
			if (bb.updateBook()) {
				rd = request.getRequestDispatcher("updatebook.jsp");
				request.setAttribute("msg", Sucessful);
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("updatebook.jsp");
				request.setAttribute("msg", Unsucessful);
				rd.forward(request, response);
			}

		} else if (request.getParameter("action").equals("Issue")) {
			String memberId = request.getParameter("memberId");
			System.out.println(memberId);
			String accessionNo = request.getParameter("accessionNo");
			System.out.println(accessionNo);
			mm.setMemberId(memberId);
			Member member = mm.getMemberInfo();
			System.out.println(member);
			if (bd.checkStatus(accessionNo) && member != null) {
				System.out.println("bd.checkStatus(accessionNo) && member != null");
				if (td.countBorrowedBooks(memberId) >= studentLimit && member.getType().equals("student")) {
					request.setAttribute("msg", "You have reached maximum limit of 2 books");
					System.out.println("td.countBorrowedBooks(memberId");
				} else if (td.countBorrowedBooks(memberId) >= staffLimit && member.getType().equals("staff")) {
					request.setAttribute("msg", "You have reached maximum limit of 3 books");
				} else {
					System.out.println("setting transaction in book controller issue method");
					Transaction t = new Transaction();
					t.setAccessionNo(accessionNo);
					t.setMemberId(memberId);
					System.out.println("aceesiopn no and mem" + accessionNo + " " + memberId);
					if (td.spawnTransaction(t)) {
						bd.changeStatus(accessionNo, "Not available");
						rd = request.getRequestDispatcher("issuebook.jsp");
						request.setAttribute("msg", "Book Issued..");
						rd.forward(request, response);
					}
				}

			} else {
				request.setAttribute("msg", "Book or Member is not available");
				request.getRequestDispatcher("issuebook.jsp").forward(request, response);
			}

		} else if (request.getParameter("action").equals("Return")) {
			String accessionNo = request.getParameter("accessionNo");
			ArrayList<Transaction> accessionNos = td.retrieveAccessionNos();
			request.setAttribute("accessionNos", accessionNos);
			int fine = td.returnBook(accessionNo);
			bd.changeStatus(accessionNo, "Available");
			System.out.println("fine " + fine);
			request.setAttribute("msg", "Your Fine Amount is " + fine);
			request.getRequestDispatcher("returnbook.jsp").forward(request, response);
		}

	}

}
