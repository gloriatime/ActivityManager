package model;

import java.util.Date;

public class TeamComment {
	private int Id;
	private int team;
	private Date date = new Date();
	private String content;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team  = team;
	}
}
