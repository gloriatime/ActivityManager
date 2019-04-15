package dao;

import java.util.List;

import model.Team;
import model.TeamComment;
import model.UserTeam;

public interface TeamDao {
	
	public int addTeam(Team team);
	
	public Team getTeamById(int Id);
	
	
}
