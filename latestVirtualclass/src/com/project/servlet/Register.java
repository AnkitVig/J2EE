package com.project.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;

import com.project.util.ConnectionFactory;

@WebServlet("/register")
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6291726516705610828L;
	private Connection connection;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorString1=null;
		try {
			int i=0;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String phoneNo = request.getParameter("phoneno");
			String branch = request.getParameter("branch");
			String password = request.getParameter("password");
			String role = request.getParameter("user");

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = ConnectionFactory.getConnection();

			String sql="insert into XBBNHPF_USER(username,password,name,phoneNo,branch,role) values(?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, username);
			System.out.println(password);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, phoneNo);
			ps.setString(5, branch);
			ps.setString(6, role);
			 i = ps.executeUpdate();
	
			System.out.println("value of i");
			System.out.println(i);
			

				response.sendRedirect(request.getContextPath() + "/afterSignUp.jsp");
				out.print("You are successfully registered...");

		} catch (Exception e2) {
			response.sendRedirect(request.getContextPath() + "/signUp.jsp");
			
			errorString1="Cannot be Registered, Username already in use.";
			HttpSession session = request.getSession(true);
			session.setAttribute("errorString1", errorString1);
			e2.printStackTrace();
		}

	
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}