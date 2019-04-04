package service;

import java.util.List;

import model.Comment;
import model.TeamComment;

public interface CommentService {
	
	// 发表评论
	public void addComment(Comment c);
	public void addTeamComment(TeamComment tc);
	
	// 通过活动查询对应评论
	public List<Comment> getCommentListByActId(int Id);
	public List<TeamComment> getTeamCommentListByActId(int Id);
	
	// 个人查询自己的评论
	public List<Comment> getCommentListByUserId(int Id);
	
	// 队伍查询本队评论
	public List<TeamComment> getTeamCommentListByTeamId(int Id);
}
