package com.mt.generatepassport.entities;

public class Passport {

	private int id;
	private int passportNo;
	private String issuePlace;
	private String date;
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, int passportNo, String issuePlace, String String) {
		super();
		this.id = id;
		this.passportNo = passportNo;
		this.issuePlace = issuePlace;
		this.date = String;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public String getIssuePlace() {
		return issuePlace;
	}
	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNo=" + passportNo + ", issuePlace=" + issuePlace + ", date=" + date
				+ "]";
	}
	
	
}
