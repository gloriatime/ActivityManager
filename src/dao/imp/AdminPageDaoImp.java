package dao.imp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.ActivityDao;
import dao.AdminPageDao;
import model.Activity;
import model.AdminPage;
import model.Comment;
import model.User;

@Transactional(readOnly = false)
public class AdminPageDaoImp extends HibernateDaoSupport implements AdminPageDao{

	@Override
	public AdminPage getAdminPage() {
		// TODO Auto-generated method stub
		AdminPage ap = new AdminPage();
		//System.out.println("统计页面显示：------------------------------------"+getHibernateTemplate().find("select count(*) from Activity as activity").listIterator().next());
		Long temp = (Long) getHibernateTemplate().find("select count(*) from Activity as activity").listIterator().next();
		Integer count_act = new Integer(String.valueOf(temp));
		ap.setCount_act( count_act );
		temp = (Long) getHibernateTemplate().find("select count(*) from Team as team").listIterator().next();
		Integer count_team = new Integer(String.valueOf(temp));
		ap.setCount_team( count_team );
		temp = (Long) getHibernateTemplate().find("select count(*) from User as user").listIterator().next();
		Integer count_user = new Integer(String.valueOf(temp));
		ap.setCount_user( count_user );
		
		Date begin,end,now = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(now);
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	    begin = c.getTime();
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	    end = c.getTime();
		
		ap.setNew_comment_in_this_week((List<Comment>)getHibernateTemplate().find("from Comment where date between ?0 and ?1",begin,end));
		ap.setAct_begin_in_this_week((List<Activity>)getHibernateTemplate().find("from Activity where begin between ?0 and ?1",begin,end));
		ap.setAct_have_warning((List<Activity>)getHibernateTemplate().find("from Activity where warning!=null"));
		
		return ap;
	}
		
}
