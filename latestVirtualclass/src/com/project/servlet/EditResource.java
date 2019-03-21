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
import com.project.model.*;

@WebServlet("/editResource")
public class EditResource extends HttpServlet {

	private static final long serialVersionUID = 7920179408325418034L;

	public EditResource() {
		super();
	}

	private ResourceDao resDao = new ResourceDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pptName = (String) request.getParameter("pptName");

		Resource resource = null;

		String errorString = null;

		try {
			resource = resDao.findResource(pptName);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && resource == null) {
			response.sendRedirect(request.getServletPath()
					+ "/manageResourceList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("resource", resource);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/editResource.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}