package model;

import java.util.Date;

public class Comment {
	private int Id;
	private int critic;
	private Date date = new Date();;
	private String content;
	private int belong;
	
	private User critic_user;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCritic() {
		return critic;
	}
	public void setCritic(int critic) {
		this.critic = critic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBelong() {
		return belong;
	}
	public void setBelong(int belong) {
		this.belong = belong;
	}
	public User getCritic_user() {
		return critic_user;
	}
	public void setCritic_user(User critic_user) {
		this.critic_user = critic_user;
	}
}
