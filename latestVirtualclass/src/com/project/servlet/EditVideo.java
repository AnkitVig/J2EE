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

@WebServlet("/editVideo")
public class EditVideo extends HttpServlet {

	private static final long serialVersionUID = 5835190088193280768L;

	public EditVideo() {
		super();
	}

	private VideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String videoName = (String) request.getParameter("videoName");

		Video video = null;

		String errorString = null;

		try {
			video = videoDao.findVideo(videoName);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && video == null) {
			response.sendRedirect(request.getServletPath() + "/manageVideoList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("video", video);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/editVideo.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}