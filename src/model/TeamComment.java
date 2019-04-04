package model;

import java.util.Date;

public class TeamComment {
	private int Id;
	private int team;
	private Date date = new Date();
	private String content;
	private int belong;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCritic() {
		return team;
	}
	public void setCritic(int team) {
		this.team = team;
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
}
