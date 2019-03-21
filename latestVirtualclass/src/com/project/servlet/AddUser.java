package com.project.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.UserAccountDao;
import com.project.dao.impl.UserAccountDaoImpl;
import com.project.model.UserAccount;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {

	private static final long serialVersionUID = 6909861615830601898L;

	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserAccountDao userDao = new UserAccountDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		String name = (String) request.getParameter("name");
		String phoneNo = request.getParameter("phoneno");
		String branch = request.getParameter("branch");
		String role = request.getParameter("role");
		int x=10;
		/*
		 * HttpSession session = request.getSession(true); String
		 * faculty=(String) session.getAttribute("userName");
		 */
		UserAccount user = new UserAccount(userName, password, name, phoneNo,
				branch, role);

		String errorString5 = null;
		x=	userDao.insertUser(user);
		
			
			
			System.out.println(x);
			
		

		// Store infomation to request attribute, before forward to views.
		//request.setAttribute("errorString", errorString);
		request.setAttribute("user", user);

		// If error, forward to Edit page.
		if ( x==0) {
			response.sendRedirect(request.getContextPath() + "/addUser.jsp");
			errorString5="Cannot be Inserted, Username already in use.";
			HttpSession session = request.getSession(true);
			session.setAttribute("errorString5", errorString5);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else if(x==1){
			response.sendRedirect(request.getContextPath() + "/adminDatabase");
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
