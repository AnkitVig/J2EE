package com.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserAccountDao;
import com.project.dao.impl.UserAccountDaoImpl;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = -8729439079654657515L;
	private UserAccountDao userDao = new UserAccountDaoImpl();

	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = (String) request.getParameter("userName");

		String errorString = null;

		try {
			userDao.deleteVideo(userName);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null) {

			request.setAttribute("errorString", errorString);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/adminDatabase");
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/adminDatabase");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
