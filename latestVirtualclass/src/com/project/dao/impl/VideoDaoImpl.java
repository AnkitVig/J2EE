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

public class VideoDaoImpl implements VideoDao {

	private Connection connection;
	private PreparedStatement preparedStatment;

	public Video findVideo(String videoName) {
		Video video = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Select a.videoName ,a.videoLink, a.subject from XBBNHPF_VIDEO a where a.videoName=?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, videoName);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String videoLink = rs.getString("videoLink");
				String subject = rs.getString("subject");
				video = new Video(videoName, videoLink, subject);

			}
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
		return video;
	}

	public void updateVideo(Video video) {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Update XBBNHPF_VIDEO set videoLink=?,subject =? where videoName=? ";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, video.getVideoLink());
			pstm.setString(2, video.getSubject());
			pstm.setString(3, video.getVideoName());
			System.out.println(video.getVideoLink());
			System.out.println(video.getVideoName());
			System.out.println(video.getSubject());
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
	}

	public void deleteVideo(String videoName) {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);

			String sql = "Delete from XBBNHPF_VIDEO where videoName= ?";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, videoName);

			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in get() method");
			e.printStackTrace();
		} finally {
			DbUtil.close(preparedStatment);
			DbUtil.close(connection);
		}
	}

	public int insertVideo(Video Video) {
		int x=0;
		try {

			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String sql = "Insert into XBBNHPF_VIDEO(videoName, videoLink,subject,faculty) values (?,?,?,?)";

			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setString(1, Video.getVideoName());
			pstm.setString(2, Video.getVideoLink());
			pstm.setString(3, Video.getSubject());
			pstm.setString(4, Video.getFaculty());
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

	public List<Video> queryVideo() {
		ResultSet rs = null;
		List<Video> list = new ArrayList<Video>();
		Video video = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select a.videoName, a.videoLink, a.subject,a.faculty from XBBNHPF_VIDEO a ";

			PreparedStatement pstm = connection.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String videoName = rs.getString("videoName");
				String videoLink = rs.getString("videoLink");
				String subject = rs.getString("subject");
				String faculty = rs.getString("faculty");
				video = new Video();
				video.setVideoName(videoName);
				video.setVideoLink(videoLink);
				video.setSubject(subject);
				video.setFaculty(faculty);
				list.add(video);

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

	public List<Video> queryVideo11(String userName) {
		ResultSet rs = null;
		List<Video> list = new ArrayList<Video>();
		Video video = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select a.videoName, a.videoLink, a.subject,a.faculty from XBBNHPF_VIDEO a where a.faculty=?";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userName);
			rs = pstm.executeQuery();

			while (rs.next()) {
				String videoName = rs.getString("videoName");
				String videoLink = rs.getString("videoLink");
				String subject = rs.getString("subject");
				// String faculty = rs.getString("faculty");
				video = new Video();
				video.setVideoName(videoName);
				video.setVideoLink(videoLink);
				video.setSubject(subject);
				video.setFaculty(userName);
				list.add(video);

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
