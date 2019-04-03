package service;

import java.util.List;

import model.Activity;

public interface ActivityService {
	
	// -----添加活动-----
	public void addAct(Activity activity);
	
	// -----查询活动-----
	// 通过类别查询活动（1-学习类 2-体育类 3-晚会 4-玩耍 5-其他）
	public boolean getActByClass(int classes);
	// 通过活动举行的时间长短查询活动（1-短期 2-长期）
	public boolean getActByTime(int isLong);
	// 通过活动Id查询活动
	public Activity getActById(int Id);
	// 通过活动举办人查询活动
	public void getActByOwnder(int ownerId);
	
	// ------更新活动内容-----
	// 更新该活动已有队伍数
	public void updateTeamNum(int actId);
	// 更新活动内容
	public void updateAct(Activity activity);
}
