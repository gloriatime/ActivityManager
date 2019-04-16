package action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.*;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;

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
		
		//  如果有宣传图，将宣传图保存
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
		     activity.setImg(newFileName);
		     System.out.println("图片地址："+newFileName);
		}
		
		
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
