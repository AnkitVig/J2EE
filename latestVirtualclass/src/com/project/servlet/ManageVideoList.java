package com.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.*;
import com.project.dao.impl.*;
import com.project.model.*;

@WebServlet("/manageVideoList")
public class ManageVideoList extends HttpServlet {

	private static final long serialVersionUID = -4119627755400578688L;

	public ManageVideoList() {
		super();
	}

	private VideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String faculty = (String) session.getAttribute("userUserName");
		String errorString = null;
		List<Video> list = null;
		try {
			list = videoDao.queryVideo11(faculty);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("videoList", list);

		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/manageVideo.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}