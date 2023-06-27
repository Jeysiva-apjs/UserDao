package com.jey.model;

public class User {
	private int id;
	private String name;
	private String designation;
	private String mailId;
	private String location;
	private String reportsTo;
	
	
	public User() {
		super();
	}
	public User(int id, String name, String designation, String mailId, String location, String reportsTo) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.mailId = mailId;
		this.location = location;
		this.reportsTo = reportsTo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
	
	
	

}
