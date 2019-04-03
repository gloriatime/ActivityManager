package service.imp;

import java.util.List;

import dao.ActivityDao;
import dao.UserDao;
import model.Activity;
import service.ActivityService;

public class ActivityServiceImp implements ActivityService{
	
	private ActivityDao activityDao;
	
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	
	@Override
	public void addAct(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.addAct(activity);
	}

	@Override
	public boolean getActByClass(int classes) {
		// TODO Auto-generated method stub
		
		return activityDao.getActByClass(classes);
	}

	@Override
	public boolean getActByTime(int isLong) {
		// TODO Auto-generated method stub
		
		return activityDao.getActByTime(isLong);
	}

	@Override
	public Activity getActById(int Id) {
		// TODO Auto-generated method stub
		return activityDao.getActById(Id);
	}

	@Override
	public void updateTeamNum(int actId) {
		// TODO Auto-generated method stub
		activityDao.updateTeamNum(actId);
	}

	@Override
	public void getActByOwnder(int ownerId) {
		// TODO Auto-generated method stub
		
		activityDao.getActByOwner(ownerId);
		
	}

	@Override
	public void updateAct(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.updateAct(activity);
	}
	
}
