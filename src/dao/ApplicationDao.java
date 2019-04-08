package dao;


import model.Application;

public interface ApplicationDao {
	
	public void addApplication(Application application);
	
	public void changeState(Application application);
	
	// 分为3种状态的申请，分别放入不同的session列表中
	public void getApplicationsByTeamId(int Id);	
	public void getApplicationsByApplicantId(int Id);
}
