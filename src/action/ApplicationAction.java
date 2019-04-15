package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Answer;
import model.Application;
import model.Team;
import model.User;
import model.UserTeam;
import service.ApplicationService;
import service.TeamService;
import service.UserService;

public class ApplicationAction extends ActionSupport{
	
	private Team team;
	private User user;
	private Answer answer;
	private Application applicationForm;
	private UserService userService;
	private TeamService teamService;
	private ApplicationService applicationService;
	 public User getUser() {
	    	return user;
	 }
	public void setUser(User user) {
	    	this.user = user;
	}
	 public Team getTeam() {
	    	return team;
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
	public Application getApplicationForm() {
		return applicationForm;
	}
	public void setApplicationForm(Application applicationForm) {
		this.applicationForm = applicationForm;
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
		
		User user = (User) ActionContext.getContext().getSession().get("user");		
		// 没登陆
		if(user == null) return "error";		
		System.out.println("application to team-------------------"+team.getId());
		System.out.println("application content-------------------"+applicationForm.getContent());
		
		applicationForm.setTeam(team.getId());
		applicationService.addApplication(applicationForm);
		
		//------------------------------后期更改：弹出一个操作成功的对话框-----------------------------------
		return "success";
	}
	
	public String ShowAppList() {
		
		team = teamService.getTeamById(team.getId());
		applicationService.getAppListByTeam(team.getId());
		return "applicationList";
	}
	
	public String ChangeToRegular() {
		
		applicationService.acceptApplication(applicationForm);
		return ShowAppList();
	}
	
	public String ChangeToRefused() {

		applicationService.denyApplication(applicationForm);
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
