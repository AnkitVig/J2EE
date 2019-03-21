package com.project.servlet;

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

@WebServlet("/doCreateResource")
public class AddRes extends HttpServlet {

	private static final long serialVersionUID = -293123852541304018L;

	public AddRes() {
		super();
	}

	private ResourceDao resDao = new ResourceDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pptname = (String) request.getParameter("pptname");
		String pptlink = (String) request.getParameter("pptlink");
		String subject = (String) request.getParameter("subject");
		HttpSession session = request.getSession(true);
		String faculty = (String) session.getAttribute("userUserName");
int x=0;
		try {

		} catch (Exception e) {
		}
		Resource res = new Resource(pptname, pptlink, subject, faculty);

		String errorString7 = null;

		
			
				x=resDao.insertResource(res);
	

		// Store infomation to request attribute, before forward to views.

		request.setAttribute("resource", res);

		// If error, forward to Edit page.
		if ( x==0) {
			response.sendRedirect(request.getContextPath() + "/addRes.jsp");
			errorString7="Cannot be Inserted, Resource Name already in use.";
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("errorString7", errorString7);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else if(x==1) {
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