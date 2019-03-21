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

@WebServlet("/doEditResource")
public class DoEditResource extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9142901381988186082L;

	public DoEditResource() {
		super();
	}

	private ResourceDao resDao = new ResourceDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pptName = (String) request.getParameter("pptName");
		String pptLink = (String) request.getParameter("pptLink");
		String subject = (String) request.getParameter("subject");

		Resource res = new Resource(pptName, pptLink, subject);

		String errorString = null;

		try {
			resDao.updateResource(res);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("resource", res);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/editResource.jsp");
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