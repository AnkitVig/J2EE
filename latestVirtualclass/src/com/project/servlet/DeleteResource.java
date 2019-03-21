package com.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.*;
import com.project.dao.impl.*;

@WebServlet("/deleteResource")
public class DeleteResource extends HttpServlet {

	private static final long serialVersionUID = 6263578174027987281L;

	public DeleteResource() {
		super();
	}

	private ResourceDao resDao = new ResourceDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pptName = (String) request.getParameter("pptName");

		String errorString = null;

		try {
			resDao.deleteResource(pptName);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If an error redirected to an error page.
		if (errorString != null) {

			// Store the information in the request attribute, before forward to
			// views.
			request.setAttribute("errorString", errorString);
			//
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/manageResourceList");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath()
					+ "/manageResourceList");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}