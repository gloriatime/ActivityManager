package dao;

import java.util.List;

import model.Team;
import model.TeamComment;

public interface TeamCommentDao {
	
	public void addTeamComment(TeamComment teamComment);
	
	public List<TeamComment> getTeamCommentByTeamId(int Id);
	
	public void deleteTeamCommentById (int Id);

	public List<TeamComment> getTeamCommentByActivityId(int Id);
}
