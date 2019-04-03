package service.imp;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.ActTeamDao;
import dao.TeamDao;
import dao.UserTeamDao;
import model.ActTeam;
import model.Team;
import model.UserTeam;
import service.TeamService;

public class TeamServiceImp implements TeamService{
	
	TeamDao teamDao;
	UserTeamDao userTeamDao;
	ActTeamDao actTeamDao;
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public void setUserTeamDao(UserTeamDao userTeamDao) {
		this.userTeamDao = userTeamDao;
	}
	public UserTeamDao  setUserTeamDao() {
		return userTeamDao;
	}
	public void setActTeamDao(ActTeamDao actTeamDao) {
		this.actTeamDao = actTeamDao;
	}
	
	@Override
	public void addTeam(Team team, int ownerId, int actId) {
		// TODO Auto-generated method stub
		int teamId = teamDao.addTeam(team);
		userTeamDao.addRelation(ownerId, teamId,1);//队伍创始人默认为队长，正式成员
		actTeamDao.addRelation(actId, teamId);
	}

	@Override
	public void getTeamByOwner(int ownerId,int regular) {
		// TODO Auto-generated method stub
		List list = userTeamDao.getTeamIdOfUser(ownerId,regular);
		
		List teamList = new ArrayList();
		
		for(int i = 0;i<list.size();i++) {
			UserTeam userTeam = (UserTeam)list.get(i);
			teamList.add(teamDao.getTeamById(userTeam.getTeam()));
		}
		if(regular==0)
			ActionContext.getContext().getSession().put("appTeamList",teamList);
		else if(regular==1)
			ActionContext.getContext().getSession().put("teamList",teamList);
		else if(regular==2)
			ActionContext.getContext().getSession().put("failTeamList",teamList);
	}

	@Override
	public void getTeamByAct(int actId) {
		// TODO Auto-generated method stub
		List list = actTeamDao.getTeamIdOfAct(actId);
		
		List teamList = new ArrayList();
		
		for(int i = 0;i<list.size();i++) {
			ActTeam actTeam = (ActTeam)list.get(i);
			teamList.add(teamDao.getTeamById(actTeam.getTeam()));
		}
		
		ActionContext.getContext().getSession().put("teamList",teamList);
	}
	@Override
	public Team getTeamById(int Id) {
		return teamDao.getTeamById(Id);
	}

}
