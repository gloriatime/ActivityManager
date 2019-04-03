package dao;

import java.util.List;

import model.Team;
import model.UserTeam;

public interface UserTeamDao {
	
	public void addRelation(int userId,int teamId,int regular);
	
	public List getTeamIdOfUser(int userId,int regular);
	
	public List getUserIdOfTeam(int teamId,int regular);
	
	public void updateRelation(UserTeam userTeam,int regular);
	
}
