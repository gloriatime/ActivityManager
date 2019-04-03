package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Activity;
import model.Team;
import model.User;
import service.ActivityService;
import service.TeamService;
import service.UserService;

public class ShowAction extends ActionSupport{
	
	User user;
	Team team;
	Activity activity;
	UserService userService;
	TeamService teamService;
	ActivityService activityService;
	
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
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public UserService getUserService() {
    	return userService;
	}
	public void setUserService(UserService userService) {
    	this.userService = userService;
	}
	public TeamService getTeamService() {
    	return teamService;
	}
	public void setTeamService(TeamService teamService) {
    	this.teamService = teamService;
	}
	public ActivityService getActivityService() {
    	return activityService;
	}
	public void setActivityService(ActivityService activityService) {
    	this.activityService = activityService;
	}
	
	// 展示主页的活动列表
	public String ShowActivity() {
		
		
		activityService.getActByTime(1);
		activityService.getActByTime(2);
		activityService.getActByClass(1);
		activityService.getActByClass(2);
		activityService.getActByClass(3);
		activityService.getActByClass(4);
		activityService.getActByClass(5);
		
		
		return "index";
	}
	
	public String ShowActInfo() {
		
		activity = activityService.getActById(activity.getId());
		user = userService.getUserById(activity.getOwner());
		teamService.getTeamByAct(activity.getId());
		
		return "actInfo";
	}
	
	public String ShowTeamForm() {
		
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// 没登陆
		if(user == null) return "error";
		activity = activityService.getActById(activity.getId());
		
		return "teamForm";
	}
	public String ShowTeamInfo() {
		
		team = teamService.getTeamById(team.getId());
		System.out.println("team.member----------------------------------------"+team.getMemberNum());
		
		return "teamInfo";
	}
	
	public String ShowPersonalPage() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// 没登陆
		if(user == null) return "error";
				
		activityService.getActByOwnder(user.getId());
		teamService.getTeamByOwner(user.getId(),0);
		teamService.getTeamByOwner(user.getId(),1);
		teamService.getTeamByOwner(user.getId(),2);
		return "personalPage";
	}
	
	public String ShowUserInfo() {
		
		user = userService.getUserById(user.getId());
		
		return "userInfo";
	}
}
