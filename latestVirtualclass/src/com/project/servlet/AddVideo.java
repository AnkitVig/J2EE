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

@WebServlet("/doCreateVideo")
public class AddVideo extends HttpServlet {

	private static final long serialVersionUID = -8614811005005801696L;

	public AddVideo() {
		super();
	}

	private VideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String videoName = (String) request.getParameter("videoName");
		String videoLink = (String) request.getParameter("videoLink");
		String subject = (String) request.getParameter("subject");
		HttpSession session = request.getSession(true);
		String faculty = (String) session.getAttribute("userUserName");
int x=0;
		try {

		} catch (Exception e) {
		}
		Video video = new Video(videoName, videoLink, subject, faculty);

		String errorString6 = null;

		
			x=	videoDao.insertVideo(video);
		
		// Store infomation to request attribute, before forward to views.
		
		request.setAttribute("video", video);

		// If error, forward to Edit page.
		if ( x==0) {
			response.sendRedirect(request.getContextPath() + "/addVideo.jsp");
			errorString6="Cannot be Inserted, Video Name already in use.";
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("errorString6", errorString6);
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