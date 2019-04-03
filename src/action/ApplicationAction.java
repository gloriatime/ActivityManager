package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Answer;
import model.Team;
import model.User;
import model.UserTeam;
import service.ApplicationService;
import service.TeamService;
import service.UserService;

public class ApplicationAction extends ActionSupport{
	
	Team team;
	User user;
	Answer answer;
	UserTeam userTeam;
	UserService userService;
	TeamService teamService;
	ApplicationService applicationService;
	 public User getUser() {
	    	return user;
	 }
	public void setUser(User user) {
	    	this.user = user;
	}
	 public Team getTeam() {
	    	return team;
	 }
	public void setUserTeam(UserTeam userTeam) {
	    	this.userTeam = userTeam;
	}
	public UserTeam getUserTeam() {
    	return userTeam;
	}
	public void setTeam(Team team) {
    	this.team = team;
	}
	public Answer getAnswer() {
    	return answer;
	}
	public void setAnswer(Answer answer) {
    	this.answer = answer;
	}
	public TeamService getTeamService() {
    	return teamService;
	}
	public UserService getUserService() {
    	return userService;
	}
	public void setUserService(UserService userService) {
    	this.userService = userService;
	}
	public void setTeamService(TeamService teamService) {
    	this.teamService = teamService;
	}
	public ApplicationService getApplicationService() {
    	return applicationService;
	}
	public void setApplicationService(ApplicationService applicationService) {
    	this.applicationService = applicationService;
	}
	
	
	public String AddApplication() {
		
		
		System.out.println("application to team-------------------"+team.getId());
		UserTeam ut = new UserTeam();
		ut.setTeam(team.getId());
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// Ã»µÇÂ½
		if(user == null) return "error";
				
		ut.setUser(user.getId());
		
		applicationService.addApplication(ut);
		return "index";
	}
	
	public String ShowAppList() {
		
		team = teamService.getTeamById(team.getId());
		applicationService.getAppListByTeam(team.getId());
		return "applicationList";
	}
	
	public String ChangeToRegular() {
		
		System.out.println("userTeamYYYY---------------------------"+user.getId()+team.getId());
		UserTeam ut = new UserTeam();
		ut.setTeam(team.getId());
		ut.setUser(user.getId());
		applicationService.changeToRegular(ut);
		return ShowAppList();
	}
	
	public String ChangeToRefused() {
		System.out.println("userTeamNNNNN---------------------------"+userTeam.getUser()+userTeam.getTeam());
		applicationService.changeToRefused(userTeam);
		return ShowAppList();
	}
	
	public String AdminTest() {
		
		if(answer.getFirst() == 1 && answer.getSecond() == 1 && answer.getThird() == 1) {
			User user = (User) ActionContext.getContext().getSession().get("user");
			userService.changeToAdmin(user.getId());
			return "success";
		}
			
		else
			return "error";
		
	}
}
