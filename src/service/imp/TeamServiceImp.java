package service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import dao.ActTeamDao;
import dao.TeamDao;
import dao.UserDao;
import model.ActTeam;
import model.Team;
import model.User;
import model.UserTeam;
import service.TeamService;

public class TeamServiceImp implements TeamService{
	
	UserDao userDao;
	TeamDao teamDao;
	ActTeamDao actTeamDao;
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public void setActTeamDao(ActTeamDao actTeamDao) {
		this.actTeamDao = actTeamDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void addTeam(Team team, int ownerId, int actId) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(ownerId);
		team.getMemberList().add(user);
		int teamId = teamDao.addTeam(team);
		
		actTeamDao.addRelation(actId, teamId);
	}

	@Override
	public void getTeamByOwner(int ownerId) {
		// TODO Auto-generated method stub
		//List list = userTeamDao.getTeamIdOfUser(ownerId,regular);
		
		Set<Team> teamList = userDao.getUserById(ownerId).getTeamList();
		ActionContext.getContext().getSession().put("teamList",teamList);
		
		/*List teamList = new ArrayList();
		
		for(int i = 0;i<list.size();i++) {
			UserTeam userTeam = (UserTeam)list.get(i);
			teamList.add(teamDao.getTeamById(userTeam.getTeam()));
		}
		if(regular==0)
			ActionContext.getContext().getSession().put("appTeamList",teamList);
		else if(regular==1)
			ActionContext.getContext().getSession().put("teamList",teamList);
		else if(regular==2)
			ActionContext.getContext().getSession().put("failTeamList",teamList);*/
		
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
	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		teamDao.update(team);
	}
	@Override
	public void delete(Team team) {
		// TODO Auto-generated method stub
		team = teamDao.getTeamById(team.getId());
		team.setQQ("该队伍已解散");
		teamDao.update(team);
	}

}
