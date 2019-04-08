package service;

import model.Application;
import model.UserTeam;

public interface ApplicationService {
	
	// 增加一个申请成员
	//public void addApplication(UserTeam userTeam);
	public void addApplication(Application application);
	
	// 申请成功成为正式成员
	public void acceptApplication(UserTeam userTeam, Application application);
	
	// 申请被拒绝了
	//public void changeToRefused(UserTeam userTeam);
	public void denyApplication(Application application);
	
	// 得到申请列表
	public void getAppListByTeam(int teamId);
	public void getApplicationsByApplicantId(int Id);
	
}
