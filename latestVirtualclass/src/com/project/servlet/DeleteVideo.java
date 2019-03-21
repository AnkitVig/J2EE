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

@WebServlet("/deleteVideo")
public class DeleteVideo extends HttpServlet {

	private static final long serialVersionUID = 7479329228774560244L;

	public DeleteVideo() {
		super();
	}

	private VideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String videoName = (String) request.getParameter("videoName");

		String errorString = null;

		try {
			videoDao.deleteVideo(videoName);
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
					.getRequestDispatcher("/manageVideoList");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/manageVideoList");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}