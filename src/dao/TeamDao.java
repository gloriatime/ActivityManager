package dao;

import java.util.List;

import model.Team;
import model.TeamComment;

public interface TeamDao {
	
	public int addTeam(Team team);
	
	public Team getTeamById(int Id);
	
	
}
