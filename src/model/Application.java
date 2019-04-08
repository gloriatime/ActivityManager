package model;

import java.util.Date;

public class Application {
	private int Id;
	private int team;
	private int applicant;
	private String content;
	private Date date = new Date();
	private String state;
	
	private User applicant_user;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getApplicant() {
		return applicant;
	}
	public void setApplicant(int applicant) {
		this.applicant = applicant;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getApplicant_user() {
		return applicant_user;
	}
	public void setApplicant_user(User applicant_user) {
		this.applicant_user = applicant_user;
	}
}
