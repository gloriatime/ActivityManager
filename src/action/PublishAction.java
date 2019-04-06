package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Activity;
import model.Team;
import model.User;
import service.ActivityService;
import service.TeamService;
import service.UserService;

public class PublishAction extends ActionSupport{
	
	Team team;
	Activity activity;
	TeamService teamService;
	ActivityService activityService;
	
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
	
	public String PublishAct() {
		activityService.addAct(activity);
		//new ShowAction().ShowActivity();
		activityService.getActByTime(1);
		activityService.getActByTime(2);
		activityService.getActByClass(1);
		activityService.getActByClass(2);
		activityService.getActByClass(3);
		activityService.getActByClass(4);
		activityService.getActByClass(5);
		
		return "activity";
	}
	
	public String PublishTeam() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// 没登陆
		if(user == null) return "error";
				
		team.setLeader(user.getId());
		team.setMemberNum(1);
		activity = activityService.getActById(activity.getId());
		System.out.println("队伍所属人------------------------------"+user.getId());
		System.out.println("队伍所属活动------------------------------"+activity.getId());
		teamService.addTeam(team, user.getId(), activity.getId());
		
		// 更新activity的队伍数
		activityService.updateTeamNum(activity.getId());
		
		// 更新session的teamList
		//teamService.getTeamByAct(activity.getId());
		
		return "team";
	}
	
	public String PublishWarning() {
		
		Activity act = new Activity();
		act=activityService.getActById(activity.getId());
		act.setWarning(activity.getWarning());
		act.setContent(activity.getContent());
		System.out.println("update-------------------------"+activity.getWarning());
		activityService.updateAct(act);
		return "success";
	}
}
