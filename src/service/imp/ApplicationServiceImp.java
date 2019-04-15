package service.imp;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.ApplicationDao;
import dao.TeamDao;
import dao.UserDao;
import dao.UserTeamDao;
import model.Application;
import model.UserTeam;
import service.ApplicationService;

public class ApplicationServiceImp implements ApplicationService{
	
	private UserDao userDao;
	private UserTeamDao userTeamDao;
	private ApplicationDao applicationDao;
	private TeamDao teamDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public UserTeamDao getUserTeamDao() {
		return userTeamDao;
	}
	public void setUserTeamDao(UserTeamDao userTeamDao) {
		this.userTeamDao = userTeamDao;
	}
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public TeamDao  getTeamDao() {
		return teamDao;
	}	
	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}
	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}
	
	@Override
	public void addApplication(Application application) {
		// TODO Auto-generated method stub
		applicationDao.addApplication(application);
	}
	
	// 此处application只需要有Id传入
	@Override
	public void acceptApplication(Application application) {
		// TODO Auto-generated method stub
		
		application = applicationDao.getApplicationById(application.getId());
		UserTeam ut = new UserTeam();
		ut.setTeam(application.getTeam());
		ut.setUser(application.getApplicant());
		userTeamDao.addMember(ut);
		application.setState("accept");
		applicationDao.changeState(application);
	}
	@Override
	public void denyApplication(Application application) {
		// TODO Auto-generated method stub
		application.setState("deny");
		applicationDao.changeState(application);
	}
	@Override
	public void getApplicationsByApplicantId(int Id) {
		// TODO Auto-generated method stub
		applicationDao.getApplicationsByApplicantId(Id);
		setApplicantUser();
	}
	@Override
	public void getAppListByTeam(int teamId) {
		// TODO Auto-generated method stub
		applicationDao.getApplicationsByTeamId(teamId);
		setApplicantUser();
	}
	
	private void setApplicantUser() {
		List<Application> list_accept = (List<Application>) ActionContext.getContext().getSession().get("accepted_applications");
		for(Application a:list_accept) {
			a.setApplicant_user(userDao.getUserById(a.getApplicant()));
		}
		List<Application> list_deny = (List<Application>) ActionContext.getContext().getSession().get("denied_applications");
		for(Application a:list_accept) {
			a.setApplicant_user(userDao.getUserById(a.getApplicant()));
		}
		List<Application> list_auditing = (List<Application>) ActionContext.getContext().getSession().get("auditing_applications");
		for(Application a:list_accept) {
			a.setApplicant_user(userDao.getUserById(a.getApplicant()));
		}
	}

}
