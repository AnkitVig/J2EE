package com.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserAccountDao;
import com.project.dao.impl.UserAccountDaoImpl;
import com.project.model.UserAccount;

@WebServlet("/adminDatabase")
public class AdminDatabase extends HttpServlet {

	private static final long serialVersionUID = -2451863952608269224L;

	public AdminDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserAccountDao userDao = new UserAccountDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String errorString = null;
		List<UserAccount> list = null;
		try {
			list = userDao.queryUser();
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("userList", list);

		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/adminUser.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
