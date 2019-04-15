package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.ApplicationDao;
import model.Application;
import model.Comment;
import model.User;

@Transactional(readOnly = false)
public class ApplicationDaoImp extends HibernateDaoSupport implements ApplicationDao {

	@Override
	public void addApplication(Application application) {
		// TODO Auto-generated method stub
		User user = new User();
		user = (User)ActionContext.getContext().getSession().get("user");
		application.setApplicant(user.getId());
		getHibernateTemplate().save(application);
	}

	@Override
	public void changeState(Application application) {
		// TODO Auto-generated method stub
		String newState = application.getState();
		application = (Application) getHibernateTemplate().find("from Application where Id=?0",application.getId()).get(0);
		application.setState(newState);
		getHibernateTemplate().update(application);
	}

	@Override
	public void getApplicationsByTeamId(int Id) {
		// TODO Auto-generated method stub
		List<Application> list_accept = (List<Application>) getHibernateTemplate().find("from Application where team=?0 and state='accept'",Id);
		ActionContext.getContext().getSession().put("accepted_applications",list_accept);
		List<Application> list_deny = (List<Application>) getHibernateTemplate().find("from Application where team=?0 and state='deny'",Id);
		ActionContext.getContext().getSession().put("denied_applications",list_deny);
		List<Application> list_auditing = (List<Application>) getHibernateTemplate().find("from Application where team=?0 and state='auditing'",Id);
		ActionContext.getContext().getSession().put("auditing_applications",list_auditing);
	}

	@Override
	public void getApplicationsByApplicantId(int Id) {
		// TODO Auto-generated method stub
		List<Application> list_accept = (List<Application>) getHibernateTemplate().find("from Application where applicant=?0 and state='accept'",Id);
		ActionContext.getContext().getSession().put("accepted_applications",list_accept);
		List<Application> list_deny = (List<Application>) getHibernateTemplate().find("from Application where applicant=?0 and state='deny'",Id);
		ActionContext.getContext().getSession().put("denied_applications",list_deny);
		List<Application> list_auditing = (List<Application>) getHibernateTemplate().find("from Application where applicant=?0 and state='auditing'",Id);
		ActionContext.getContext().getSession().put("auditing_applications",list_auditing);
	}

	@Override
	public Application getApplicationById(int Id) {
		// TODO Auto-generated method stub
		return (Application) getHibernateTemplate().find("from Application where Id=?0",Id).get(0);
	}

}
