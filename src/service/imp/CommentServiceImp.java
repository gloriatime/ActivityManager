package service.imp;

import java.util.List;

import dao.ActivityDao;
import dao.CommentDao;
import dao.TeamCommentDao;
import dao.UserDao;
import model.Comment;
import model.TeamComment;
import model.User;
import service.CommentService;

public class CommentServiceImp implements CommentService{

	private UserDao userDao;
	private ActivityDao activityDao;
	private CommentDao commentDao;
	private TeamCommentDao teamCommentDao;
	
	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		commentDao.addComment(c);
		activityDao.updateCommentNum(c.getBelong());
	}

	@Override
	public void addTeamComment(TeamComment tc) {
		// TODO Auto-generated method stub
		teamCommentDao.addTeamComment(tc);
	}

	@Override
	public List<Comment> getCommentListByActId(int Id) {
		// TODO Auto-generated method stub
		
		List<Comment> commentList = commentDao.getCommentByActivityId(Id);
		for(Comment c:commentList) {
			User critic_user = new User();
			critic_user = userDao.getUserById(c.getCritic());
			c.setCritic_user(critic_user);
		}
		
		return commentList;
	}

	@Override
	public List<TeamComment> getTeamCommentListByActId(int Id) {
		// TODO Auto-generated method stub
		return teamCommentDao.getTeamCommentByActivityId(Id);
	}

	@Override
	public List<Comment> getCommentListByUserId(int Id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByCriticId(Id);
	}

	@Override
	public List<TeamComment> getTeamCommentListByTeamId(int Id) {
		// TODO Auto-generated method stub
		return teamCommentDao.getTeamCommentByTeamId(Id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public TeamCommentDao getTeamCommentDao() {
		return teamCommentDao;
	}

	public void setTeamCommentDao(TeamCommentDao teamCommentDao) {
		this.teamCommentDao = teamCommentDao;
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

}
