package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.*;
import com.project.model.*;
import com.project.util.*;

public class ResourceDaoImpl implements ResourceDao {

	private Connection connection;
	private PreparedStatement preparedStatment;

	public List<Resource> queryResource() {
		ResultSet rs = null;
		List<Resource> list = new ArrayList<Resource>();
		Resource resource = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select a.resourceName, a.resourceLink, a.subject,a.faculty from XBBNHPF_RESOURCE a ";

			PreparedStatement pstm = connection.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String resourceName = rs.getString("resourceName");
				String resourceLink = rs.getString("resourceLink");
				String subject = rs.getString("subject");
				String faculty = rs.getString("faculty");
				resource = new Resource();
				resource.setPptName(resourceName);
				resource.setPptLink(resourceLink);
				resource.setSubject(subject);
				resource.setFaculty(faculty);
				list.add(resource);

			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return list;
	}

	public int insertResource(Resource res) {
		int x=0;
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Insert into XBBNHPF_RESOURCE(resourceName, resourceLink,subject,faculty) values (?,?,?,?)";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, res.getPptName());
			pstm.setString(2, res.getPptLink());
			pstm.setString(3, res.getSubject());
			pstm.setString(4, res.getFaculty());
			x=pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
return x;
	}

	public void deleteResource(String resourceName) {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Delete from XBBNHPF_RESOURCE where resourceName= ?";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, resourceName);

			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {

			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
	}

	public void updateResource(Resource res) {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Update XBBNHPF_RESOURCE set  resourceLink=?,subject =? where resourceName=? ";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, res.getPptLink());
			pstm.setString(2, res.getSubject());
			pstm.setString(3, res.getPptName());
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {

			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
	}

	public Resource findResource(String resourceName) {
		Resource res = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Select a.resourceName ,a.resourceLink, a.subject from XBBNHPF_RESOURCE a where a.resourceName=?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, resourceName);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String resourceLink = rs.getString("resourceLink");
				String subject = rs.getString("subject");
				res = new Resource(resourceName, resourceLink, subject);

			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return res;
	}

	public List<Resource> queryResource11(String userName) {
		ResultSet rs = null;
		List<Resource> list = new ArrayList<Resource>();
		Resource resource = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select a.resourceName, a.resourceLink, a.subject,a.faculty from XBBNHPF_RESOURCE a where a.faculty=?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);
			rs = pstm.executeQuery();

			while (rs.next()) {
				String resourceName = rs.getString("resourceName");
				String resourceLink = rs.getString("resourceLink");
				String subject = rs.getString("subject");
				// String faculty = rs.getString("faculty");
				resource = new Resource();
				resource.setPptName(resourceName);
				resource.setPptLink(resourceLink);
				resource.setSubject(subject);
				resource.setFaculty(userName);
				list.add(resource);

			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return list;
	}

}
