package dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.ActivityDao;
import model.Activity;
import model.User;

@Transactional(readOnly = false)
public class ActivityDaoImp extends HibernateDaoSupport implements ActivityDao{

	public void addAct(Activity activity) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user = (User)ActionContext.getContext().getSession().get("user");
		System.out.println("存入活动，活动发起人为："+user.getId()+user.getName());
		Activity act = new Activity();
		act.setBegin(activity.getBegin());
		act.setClasses(activity.getClasses());
		act.setContent(activity.getContent());
		act.setEnd(activity.getEnd());
		act.setIsLong(activity.getIsLong());
		act.setName(activity.getName());
		act.setTeamNum(activity.getTeamNum());
		act.setWarning(activity.getWarning());
		act.setOwner(user.getId());

		getHibernateTemplate().save(act);
	
	}

	@Override
	public boolean getActByClass(int classes) {
		
		List<Activity> list=(List<Activity>) getHibernateTemplate().find("from Activity where classes=?0",classes);
		
		ActionContext.getContext().getSession().put("loading",classes);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!loading======= "+classes);
		
		if(list.size()>0) {
			
			System.out.println("class_"+classes+"");
			 ActionContext.getContext().getSession().put("class_"+classes+"",list);
			 
			 Activity act = (Activity)list.get(0);
			 System.out.println(act.getName());
			 return true;
		 }else {
			 
			 return false;
		 }

	}

	@Override
	public boolean getActByTime(int isLong) {
		
		List<Activity> list=(List<Activity>) getHibernateTemplate().find("from Activity where isLong=?0",isLong);
		if(list.size()>0) {
			 ActionContext.getContext().getSession().put("isLong_"+isLong+"",list);
			 //System.out.println(ActionContext.getContext().getSession().get("islong_'"+isLong+"'"));
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	public Activity getActById(int Id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from Activity where Id=?0",Id);
		if(list.size()>0) {
			 return (Activity)list.get(0);
		 }else {
			 return null;
		 }
	}

	@Override
	public void updateTeamNum(int actId) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from Activity where Id=?0",actId);
		
		Activity act = (Activity)list.get(0);
		
		act.setTeamNum(act.getTeamNum()+1);
		
		getHibernateTemplate().update(act);

	}

	@Override
	public boolean getActByOwner(int owner) {
		List<Activity> list=(List<Activity>) getHibernateTemplate().find("from Activity where owner=?0",owner);
		if(list.size()>0) {
			 ActionContext.getContext().getSession().put("MyActivity",list);
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	public void updateAct(Activity activity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(activity);
	}

}
