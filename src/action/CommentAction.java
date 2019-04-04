package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Activity;
import model.Comment;
import model.TeamComment;
import model.User;
import service.ActivityService;
import service.CommentService;
import service.UserService;

public class CommentAction extends ActionSupport{
	
	private User user;
	private Comment comment;
	private TeamComment teamComment;
	private Activity activity;
	private CommentService commentService;
	private ActivityService activityService;
	private UserService userService;

	public User getUser() {
    	return user;
	}
	public void setUser(User user) {
    	this.user = user;
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
	
	public String addComment() {
		commentService.addComment(comment);
		activity = activityService.getActById(activity.getId());
		user = userService.getUserById(activity.getOwner());
		ActionContext.getContext().getSession().put("commentList", commentService.getCommentListByActId(activity.getId()));
		
		return "add_comment_finish";
	}
	
	public String showComments() {
		
		activity = activityService.getActById(activity.getId());
		user = userService.getUserById(activity.getOwner());
		ActionContext.getContext().getSession().put("commentList", commentService.getCommentListByActId(activity.getId()));
		
		return "show_comments";
	}
}
