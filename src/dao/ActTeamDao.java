package dao;

import java.util.List;

import model.Team;

public interface ActTeamDao {
	
	public void addRelation(int actId,int teamId);
	
	public List getTeamIdOfAct(int actId);
	
}
