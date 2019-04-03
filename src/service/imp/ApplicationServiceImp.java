package service.imp;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.TeamDao;
import dao.UserDao;
import dao.UserTeamDao;
import model.UserTeam;
import service.ApplicationService;

public class ApplicationServiceImp implements ApplicationService{
	
	private UserDao userDao;
	UserTeamDao userTeamDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserTeamDao(UserTeamDao userTeamDao) {
		this.userTeamDao = userTeamDao;
	}
	public UserTeamDao  setUserTeamDao() {
		return userTeamDao;
	}
	
	@Override
	public void addApplication(UserTeam userTeam) {
		// TODO Auto-generated method stub
		userTeamDao.addRelation(userTeam.getUser(), userTeam.getTeam(), 0);
	}

	@Override
	public void changeToRegular(UserTeam userTeam) {
		// TODO Auto-generated method stub
		userTeamDao.updateRelation(userTeam,1);
	}

	@Override
	public void changeToRefused(UserTeam userTeam) {
		// TODO Auto-generated method stub
		userTeamDao.updateRelation(userTeam,2);
	}
	@Override
	public void getAppListByTeam(int teamId) {
		// TODO Auto-generated method stub
		List list = userTeamDao.getUserIdOfTeam(teamId, 0);
		List userList = new ArrayList();
		for(int i = 0;i<list.size();i++) {
			UserTeam userTeam = (UserTeam)list.get(i);
			userList.add(userDao.getUserById(userTeam.getUser()));
		}
		
		ActionContext.getContext().getSession().put("appUserList",userList);
	}

}
