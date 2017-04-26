package com.library.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.model.LoginBean;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Properties p;

	@Override
	public void init() throws ServletException {
		p = new Properties();
		try {
			p.load(getServletContext().getResourceAsStream(
					"/WEB-INF/resources.properties"));

			System.out.println(p.size());
			System.out.println(p);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Controller doPost...");

		LoginBean lb = new LoginBean();
		request.setAttribute("lb", lb);

		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String type=request.getParameter("type");
		
		lb.setMemberId(memberId);
		lb.setPassword(password);
		lb.setType(type);

		if (lb.isValid())
			request.getRequestDispatcher(p.getProperty("success")).forward(
					request, response);
		else
			request.getRequestDispatcher(p.getProperty("fail")).forward(
					request, response);
	}

}
