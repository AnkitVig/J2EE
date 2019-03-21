package com.project.servlet;

//import java.awt.Window;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.*;
import com.project.dao.impl.*;
import com.project.model.*;

@WebServlet("/login")
public class DoLoginServlet extends HttpServlet {

	private static final long serialVersionUID = -361944883003647933L;

	public DoLoginServlet() {
		super();
	}

	private UserAccountDao userDao = new UserAccountDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserAccount user1 = null;

		boolean hasError = false;
		String errorString4 = null;

		if (userName == null || password == null || userName.length() == 0
				|| password.length() == 0) {
			hasError = true;
			errorString4 = "Required username and password!";
		} else {

			try {
				user1 = userDao.findUser(userName, password);

				if (user1 == null) {
					hasError = true;
					errorString4 = "User Name or password invalid";
					System.out.println(errorString4);
					HttpSession session = request.getSession(true);
					session.setAttribute("errorString4", errorString4);
				}
			} catch (Exception e) {
				e.printStackTrace();
				hasError = true;
				errorString4 = e.getMessage();
				HttpSession session = request.getSession(true);
				session.setAttribute("errorString4", errorString4);
			}
		}

		if (hasError) {
			user1 = new UserAccount();
			user1.setUserName(userName);
			user1.setPassword(password);

			request.setAttribute("user", user1);

			response.sendRedirect(request.getContextPath() + "/index.jsp");

			HttpSession session = request.getSession(true);
			session.setAttribute("errorString4", errorString4);
		} else {

			HttpSession session = request.getSession(true);
			session.setAttribute("errorString4", errorString4);

			try {
				UserAccount user2 = userDao.checkDetail(userName);
				session.setAttribute("checkDetail", user2);
				session.setAttribute("userName", user2.getName());
				session.setAttribute("userUserName", user2.getUserName());
			//	System.out.println(user2.getPhoto());
				session.setAttribute("photo", user2.getPhoto());
				session.setAttribute("phoneNo", user2.getPhoneNo());
				session.setAttribute("branch", user2.getBranch());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user1.getRole().equals("admin")) {

				getServletContext().getRequestDispatcher("/adminHome.jsp")
						.forward(request, response);
			} else if (user1.getRole().equals("student"))
				getServletContext().getRequestDispatcher("/studentHome.jsp")
						.forward(request, response);
			else
				getServletContext().getRequestDispatcher("/teacherHome.jsp")
						.forward(request, response);

		}
		request.setAttribute("errorString4", errorString4);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
