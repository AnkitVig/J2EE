package com.project.model;

public class Resource {
	public Resource(String pptName, String pptLink, String subject,
			String faculty) {
		super();
		this.pptName = pptName;
		this.pptLink = pptLink;
		this.subject = subject;
		this.faculty = faculty;
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String pptName;
		public Resource(String pptName, String pptLink, String subject) {
		super();
		this.pptName = pptName;
		this.pptLink = pptLink;
		this.subject = subject;
	}

		private String pptLink;

	private String subject;
	private String faculty;
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getPptName() {
		return pptName;
	}

	public void setPptName(String pptName) {
		this.pptName = pptName;
	}

	public String getPptLink() {
		return pptLink;
	}

	public void setPptLink(String pptLink) {
		this.pptLink = pptLink;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
