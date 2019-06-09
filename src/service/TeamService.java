package service;

import java.util.List;

import model.Team;

public interface TeamService{
	
	public void addTeam(Team team,int ownerId,int actId);
	
	public void getTeamByAct(int actId);
	
	public Team getTeamById(int Id);

	public void getTeamByOwner(int ownerId);
	
	public void updateTeam(Team team);
	
	public void delete(Team team);
}
