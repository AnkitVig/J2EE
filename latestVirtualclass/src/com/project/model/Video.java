package com.project.model;

public class Video {
	public Video(String videoName, String videoLink, String subject,
			String faculty) {
		super();
		this.videoName = videoName;
		this.videoLink = videoLink;
		this.subject = subject;
		this.faculty = faculty;
	}

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(String videoName, String videoLink, String subject) {
		super();
		this.videoName = videoName;
		this.videoLink = videoLink;
		this.subject = subject;
	}

	private String videoName;
	private String videoLink;
	private String subject;
	private String faculty;
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
