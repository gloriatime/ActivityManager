package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Activity;
import model.Team;
import model.User;
import service.ActivityService;
import service.TeamService;
import service.UserService;

public class ManageAction extends ActionSupport{
	private User user;
	private Team team;
	private Activity activity;
	private UserService userService;
	private TeamService teamService;
	private ActivityService activityService;
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
	
	public String FixAct() {
		
		System.out.println("修改活动："+activity.getId()+activity.getContent());
		Activity oldActivity = activityService.getActById(activity.getId());
		
			// 如果有宣传图，将宣传图保存
			if(activity.getImage()!=null) {
				System.out.println("有图！！！！！！！！！！！！！！！！！！！！！");
				 String name = RandomStringUtils.randomAlphanumeric(10);
			     String newFileName = name + ".jpg";
			     File newFile = new File(ServletActionContext.getServletContext().getRealPath("/image"), newFileName);
			     newFile.getParentFile().mkdirs();
			     File f = activity.getImage();
			     try {
			    	 FileUtils.copyFile(f, newFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			     oldActivity.setImg(newFileName);
			     System.out.println("图片地址："+newFileName);
			}
			
			oldActivity.setContent(activity.getContent());
			oldActivity.setBegin(activity.getBegin());
			oldActivity.setEnd(activity.getEnd());
			oldActivity.setName(activity.getName());
			oldActivity.setIsLong(activity.getIsLong());
			oldActivity.setClasses(activity.getClasses());
		
			
			activityService.updateAct(oldActivity);
			activity = oldActivity;
		
		return "manage_fixAct";
	}
	
public String FixTeam() {
		
		Team oldTeam = teamService.getTeamById(team.getId());
		team.setLeader(oldTeam.getLeader());
		team.setMemberNum(oldTeam.getMemberNum());
		team.setMemberList(oldTeam.getMemberList());
		teamService.updateTeam(team);
		return "manage_fixTeam";
	}

public String FixUser() {
	// ActionContext.getContext().getSession().replace("user", user);
	userService.update(user);
	return "manage_fixUser";
}

public String DissolveTeam() {
	

	teamService.delete(team);
	return "manage_dissolveTeam";
}

}
