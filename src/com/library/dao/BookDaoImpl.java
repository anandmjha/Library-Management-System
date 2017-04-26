package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.library.model.Book;
import com.library.model.Transaction;
import com.library.util.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class BookDaoImpl implements BookDao, TransactionDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	ArrayList<Book> al;
	ArrayList<Transaction> tl;
	boolean isReflected = false;
	static int transId = 10000001;

	@Override
	public int addBook(Book book) {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into book values(?,?,?,?);");
			ps.setString(1, book.getAccessionNo());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getStatus());
			if (ps.executeUpdate() == 1) {
				return 1;
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return 2;
		} catch (SQLException e) {
			e.printStackTrace();
			return 3;

		} finally

		{
			DBUtil.close(con);
		}
		return 0;
	}

	@Override
	public boolean deleteBook(String accessionNo) {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from book where accessionNo=?;");
			ps.setString(1, accessionNo);
			int i = ps.executeUpdate();
			if (i != 0) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return isReflected;

	}

	@Override
	public boolean updateBook(Book book) {

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update book set title=?,author=?,status=? where accessionNo=?");
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getStatus());
			ps.setString(4, book.getAccessionNo());
			if (ps.executeUpdate() == 1) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isReflected;
	}

	@Override
	public boolean checkStatus(String accessionNo) {
		try {
			System.out.println("checkStaus-");
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select status from book where accessionNo=?;");
			ps.setString(1, accessionNo);
			rs = ps.executeQuery();
			System.out.println("checkStaus++");
			if (rs.next()) {
				String status = rs.getString(1);
				if (status.equalsIgnoreCase("Available"))
					System.out.println(status);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return false;
	}

	@Override
	public boolean changeStatus(String accessionNo, String status) {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update book set status=? where accessionNo=?;");
			ps.setString(1, status);
			ps.setString(2, accessionNo);
			int i = ps.executeUpdate();
			if (i != 0) {
				isReflected = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Book viewBook(String accessionNo) {

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from book where accessionNo=?;");
			ps.setString(1, accessionNo);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return null;
	}

	@Override
	public ArrayList<Book> viewAll() {

		ArrayList<Book> books = new ArrayList<Book>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from book;");
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return books;
	}

	@Override
	public ArrayList<Book> viewByAuthor(String author) {
		ArrayList<Book> al = new ArrayList<Book>();
		try {

			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from book where author=?");
			ps.setString(1, author);

			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setAccessionNo(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setStatus(rs.getString(4));
				al.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}

	@Override
	public ArrayList<Book> viewByAccessionNo(String accessionNo) {
		ArrayList<Book> al = new ArrayList<Book>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from book where accessionNo=?");
			ps.setString(1, accessionNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setAccessionNo(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setStatus(rs.getString(4));
				al.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return al;
	}

	@Override
	public ArrayList<Book> viewByTitle(String title) {
		al = new ArrayList<Book>();

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from book where title=?");
			ps.setString(1, title);

			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setAccessionNo(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setStatus(rs.getString(4));
				al.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return al;
	}

	@Override
	public boolean spawnTransaction(Transaction transaction) {
		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(
					"insert into transaction (memberId,accessionNo,transactionId,issueDate,dueDate) values(?,?,?,NOW(),NOW()+INTERVAL + 7 DAY);");
			ps.setString(1, transaction.getMemberId());
			ps.setString(2, transaction.getAccessionNo());
			ps.setInt(3, transId++);
			System.out.println("hi in trasaction");
			System.out.println("transId " +transId);
			if (ps.executeUpdate() == 1) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return isReflected;

	}

	@Override
	public ArrayList<Transaction> retrieveAll() {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from transaction;");
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getString(8));
				tl.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return null;
	}

	@Override
	public ArrayList<Transaction> retrieveBorrowedBooks(String memberId) {
		try {
			tl = new ArrayList<Transaction>();
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"select transaction.accessionNo,title,author,issueDate,dueDate,returnDate,fineAmount,transaction.status from book,transaction where book.accessionNo=transaction.accessionNo and transaction.memberId=?;");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction t = new Transaction();
				t.setAccessionNo(rs.getString(1));
				t.setTitle(rs.getString(2));
				t.setAuthor(rs.getString(3));
				t.setIssueDate(rs.getDate(4));
				t.setDueDate(rs.getDate(5));
				t.setReturnDate(rs.getDate(6));
				t.setFineAmount(rs.getInt(7));
				t.setStatus(rs.getString(8));
				tl.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tl;
	}

	@Override
	public ArrayList<Transaction> retrieveAccessionNos() {
		tl = new ArrayList<Transaction>();
		try {
			con = DBUtil.getConnection();
			System.out.println("in retrive accessionNo");
			ps = con.prepareStatement("select accessionNo from transaction where status='open';");
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction t = new Transaction();
				System.out.println(rs.getString(1));
				t.setAccessionNo(rs.getString(1));
				tl.add(t);
			}
			System.out.println(tl.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return tl;
	}

	@Override
	public int returnBook(String accessionNo) {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"update transaction set returnDate=NOW(),fineAmount=((returnDate - dueDate)*1),status='close' where accessionNo=?");
			ps.setString(1, accessionNo);
			System.out.println("update query in return book executed");
			int i = ps.executeUpdate();
			if (i != 0) {
				ps = con.prepareStatement("select fineAmount from transaction where accessionNo=?");
				ps.setString(1, accessionNo);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("its here");
					if (rs.getInt(1) < 0)
						return 0;
					else
						return rs.getInt(1);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return 0;
	}

	@Override
	public int countBorrowedBooks(String memberId) {
		int c = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"select transaction.accessionNo from member,transaction where transaction.memberId=member.memberId and transaction.status='open' and transaction.memberId=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next())
				c++;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return c;
	}

}
