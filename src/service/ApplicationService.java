package service;

import model.UserTeam;

public interface ApplicationService {
	
	// 增加一个申请成员
	public void addApplication(UserTeam userTeam);
	
	// 申请成功成为正式成员
	public void changeToRegular(UserTeam userTeam);
	
	// 申请被拒绝了
	public void changeToRefused(UserTeam userTeam);
	
	// 得到申请列表
	public void getAppListByTeam(int teamId);
}
