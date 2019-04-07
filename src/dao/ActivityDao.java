package dao;

import model.Activity;

public interface ActivityDao {
	
	public void addAct(Activity activity);
	
	public boolean getActByClass(int classes);
	
	public boolean getActByTime(int isLong);
	
	public boolean getActByOwner(int owner);
	
	public Activity getActById(int Id);
	
	// 某活动的队伍数+1
	public void updateTeamNum(int actId);
	
	// 评论数+1
	public void updateCommentNum(int actId);
	
	// 更新活动内容
	public void updateAct(Activity activity);
}
