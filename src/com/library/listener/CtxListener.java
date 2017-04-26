package com.library.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.library.dao.BookDao;
import com.library.dao.BookDaoImpl;
import com.library.model.Book;

/**
 * Application Lifecycle Listener implementation class CtxListener
 *
 */
public class CtxListener implements ServletContextListener {
	BookDao bd = new BookDaoImpl();
	ArrayList<Book> books;

	/**
	 * Default constructor.
	 */
	public CtxListener() {
		System.out.println("Ctxlistener created..."); // TODO Auto-generated
														// constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		books.clear();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		books = bd.viewAll();
		sce.getServletContext().setAttribute("books", books);
		System.out.println("Context initialized   " + books);
	}

}
