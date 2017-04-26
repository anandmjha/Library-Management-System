package com.library.controller;

import java.io.IOException;
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
import com.library.model.Member;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDao md;
	BookDao bd;
	Member mm;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		md = new MemberDaoImpl();
		bd = new BookDaoImpl();
		mm = new Member();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession hs = request.getSession();

		if (request.getParameter("action").equals("Login")) {
			String memberId = request.getParameter("memberId");
			String password = request.getParameter("password");
			String type = request.getParameter("type");

			if (md.validateMember(memberId, password, type)) {

				Member member = md.getMemberData(memberId);

				hs.setAttribute("member", member);

				if (type.equalsIgnoreCase("librarian")) {
					System.out.println("in librarian dispatcher");
					request.getSession().setAttribute("memberId", memberId);
					rd = request.getRequestDispatcher("librarianmenu.jsp");
				}
				if (type.equalsIgnoreCase("staff")) {
					request.getSession().setAttribute("memberId", memberId);

					rd = request.getRequestDispatcher("membermenu.jsp");
				}
				if (type.equalsIgnoreCase("student")) {
					request.getSession().setAttribute("memberId", memberId);
					rd = request.getRequestDispatcher("membermenu.jsp");
				}
			} else
				rd = request.getRequestDispatcher("loginerror.jsp");

			rd.forward(request, response);

		}

		else if (request.getParameter("action").equals("AddMember")) {
			String memberId = request.getParameter("memberId");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String type = request.getParameter("type");
			String Sucessful="Member Added Sucessfully";
			String Duplicate="Member Id Already Exist";
			String Unucessful="Something Went Terribly Wrong";
			mm.setMemberId(memberId);
			mm.setName(name);
			mm.setAddress(address);
			mm.setType(type);
			int memberAdded=mm.getAddMember();
			if(memberAdded== 1){
				rd = request.getRequestDispatcher("addmember.jsp");
				request.setAttribute("msg",Sucessful);
				rd.forward(request, response);
			}else if(memberAdded== 2){
				rd = request.getRequestDispatcher("addmember.jsp");
				request.setAttribute("msg",Duplicate);
				rd.forward(request, response);
			}else{
				rd = request.getRequestDispatcher("addmember.jsp");
				request.setAttribute("msg",Unucessful);
				rd.forward(request, response);
			}

		} else if (request.getParameter("action").equals("DeleteMember")) {
			String memberId = request.getParameter("memberId");
			mm.setMemberId(memberId);
			mm.getDeleteMember();

		} else if (request.getParameter("action").equals("Logout")) {
			hs = request.getSession();
			hs.invalidate();
			request.getRequestDispatcher("logout.jsp").forward(request, response);

		}

	}

}
