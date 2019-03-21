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

@WebServlet("/doEditVideo")
public class DoEditVideo extends HttpServlet {

	private static final long serialVersionUID = -7298904442406055931L;

	public DoEditVideo() {
		super();
	}

	private VideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String videoName = (String) request.getParameter("videoName");
		String videoLink = (String) request.getParameter("videoLink");
		String subject = (String) request.getParameter("subject");

		Video video = new Video(videoName, videoLink, subject);

		String errorString = null;

		try {
			videoDao.updateVideo(video);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("video", video);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/editVideo.jsp");
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