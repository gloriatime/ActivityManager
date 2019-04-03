package dao;

import java.util.List;

import model.Team;

public interface TeamDao {
	
	public int addTeam(Team team);
	
	public Team getTeamById(int Id);
	
	
}
