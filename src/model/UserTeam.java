package model;

import java.io.Serializable;

public class UserTeam implements Serializable{

	private int user;
	private int team;
	
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
}
