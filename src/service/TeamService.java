package service;

import java.util.List;

import model.Team;

public interface TeamService{
	
	public void addTeam(Team team,int ownerId,int actId);
	
	public void getTeamByAct(int actId);
	
	public Team getTeamById(int Id);

	void getTeamByOwner(int ownerId);
}
