package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Activity;
import model.Comment;
import model.Team;
import model.TeamComment;
import model.User;
import service.ActivityService;
import service.CommentService;
import service.TeamService;
import service.UserService;

public class CommentAction extends ActionSupport{
	
	private User user;
	private Team team;
	private Comment comment;
	private TeamComment teamComment;
	private Activity activity;
	private CommentService commentService;
	private ActivityService activityService;
	private UserService userService;
	private TeamService teamService;

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
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public TeamComment getTeamComment() {
		return teamComment;
	}

	public void setTeamComment(TeamComment teamComment) {
		this.teamComment = teamComment;
	}
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	public ActivityService getActivityService() {
    	return activityService;
	}
	public void setActivityService(ActivityService activityService) {
    	this.activityService = activityService;
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
	
	public String AddComment() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// 没登陆
		if(user == null) return "error";
		
		comment.setBelong(activity.getId());
		commentService.addComment(comment);
		
		user = userService.getUserById(activity.getOwner());
		activity = activityService.getActById(activity.getId());
		ActionContext.getContext().getSession().put("commentList", commentService.getCommentListByActId(activity.getId()));
		ActionContext.getContext().getSession().put("teamList",null);
		return "add_comment_finish";
	}
	
	public String AddTeamComment() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		// 没登陆
		if(user == null) return "error";
		
		team = teamService.getTeamById(team.getId());
		teamComment.setTeam(team.getId());
		commentService.addTeamComment(teamComment);
		ActionContext.getContext().getSession().put("teamCommentList", commentService.getTeamCommentListByTeamId(team.getId()));
		ActionContext.getContext().getSession().put("IsTeamMember", true);
		// 清理动态的值，防止表单被初始化
		teamComment.setContent(null);
		
		return "add_teamComment_finish";
	}
	
	public String ShowComments() {
		
		activity = activityService.getActById(activity.getId());
		user = userService.getUserById(activity.getOwner());
		ActionContext.getContext().getSession().put("commentList", commentService.getCommentListByActId(activity.getId()));
		// 清理小队列表
		ActionContext.getContext().getSession().put("teamList", null);
		
		return "show_comments";
	}
	
	public String ShowCommentForm() {
		activity = activityService.getActById(activity.getId());
		
		return "show_comment_form";
	}
}
