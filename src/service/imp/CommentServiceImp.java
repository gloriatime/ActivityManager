package service.imp;

import java.util.List;

import dao.CommentDao;
import dao.TeamCommentDao;
import model.Comment;
import model.TeamComment;
import service.CommentService;

public class CommentServiceImp implements CommentService{

	private CommentDao commentDao;
	private TeamCommentDao teamCommentDao;
	
	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		commentDao.addComment(c);
	}

	@Override
	public void addTeamComment(TeamComment tc) {
		// TODO Auto-generated method stub
		teamCommentDao.addTeamComment(tc);
	}

	@Override
	public List<Comment> getCommentListByActId(int Id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByActivityId(Id);
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

}
