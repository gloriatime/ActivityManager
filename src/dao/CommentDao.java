package dao;

import java.util.List;

import model.Comment;

public interface CommentDao {
	
	public void addComment(Comment comment);
	
	public List<Comment> getCommentByCriticId(int Id);
	
	public void deleteCommentById (int Id);

	public List<Comment> getCommentByActivityId(int Id);
}
