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

public class UserAccountDaoImpl implements UserAccountDao {

	private Connection connection;
	private PreparedStatement preparedStatment;

	public UserAccountDaoImpl() {
	}

	public UserAccount findUser(String userName, String password) {
		ResultSet rs = null;
		UserAccount user = null;
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Select a.userName, a.password,a.role from XBBNHPF_USER a "
					+ " where a.userName = ? and a.password= ?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			rs = pstm.executeQuery();

			if (rs.next()) {
				user = new UserAccount(rs.getString(1), rs.getString(2),
						rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return user;
	}

	public UserAccount checkDetail(String userName) {
		ResultSet rs = null;
		UserAccount user = new UserAccount();
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Select a.userName, a.name,a.phoneNo,a.branch,a.photo from XBBNHPF_USER a "
					+ " where a.userName = ?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);

			rs = pstm.executeQuery();

			if (rs.next()) {

				user = new UserAccount(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getString(5));

			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return user;
	}

	public UserAccount findUser(String userName) {
		ResultSet rs = null;
		UserAccount user = new UserAccount();
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Select a.userName, a.password from XBBNHPF_USER a "
					+ " where a.userName = ?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);

			rs = pstm.executeQuery();

			if (rs.next()) {
				String password = rs.getString("Password");

				user.setUserName(userName);
				user.setPassword(password);
			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return user;
	}

	public List<UserAccount> queryUser() {
		ResultSet rs = null;
		List<UserAccount> list = new ArrayList<UserAccount>();
		UserAccount user = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select a.userName, a.password, a.name,a.phoneNo, a.branch,a.role from XBBNHPF_USER a ";

			PreparedStatement pstm = connection.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phoneNo = rs.getString("phoneNo");
				String branch = rs.getString("branch");
				String role = rs.getString("role");
				user = new UserAccount();
				user.setUserName(userName);
				user.setPassword(password);
				user.setName(name);
				user.setPhoneNo(phoneNo);
				user.setBranch(branch);
				user.setRole(role);
				list.add(user);

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

	public void deleteVideo(String userName) {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Delete from XBBNHPF_USER where userName= ?";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, userName);

			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
	}

	public int insertUser(UserAccount user) {
		int x=0;
		try {

			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Insert into XBBNHPF_USER(username,password,name,phoneNo,branch,role)  values (?,?,?,?,?,?)";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getName());
			pstm.setString(4, user.getPhoneNo());
			pstm.setString(5, user.getBranch());
			pstm.setString(6, user.getRole());

		x=pstm.executeUpdate();
		
		} catch (SQLException e) {
	
			System.out.println("SQLException in get() method");
			e.printStackTrace();
			return 0;
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return x;
	}
}
