package dao.imp;


import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.UserDao;
import model.User;

@Transactional(readOnly = false)
public class UserDaoImp  extends HibernateDaoSupport implements UserDao{
	
	@Transactional(readOnly = false)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}


	public boolean checkUser(User user) {
		
		String str[]= {user.getName().toString(),user.getPwd().toString()};
		List list=getHibernateTemplate().find("from User where name=?0 and pwd=?1",str);

		 if(list.size()>0) {
			 ActionContext.getContext().getSession().put("user",(User)list.get(0));

			 return true;
		 }
			 
		 else
			 return false;
	}


	@Override
	public User getUserById(int Id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from User where Id=?0",Id);

		 if(list.size()>0) {
			 User user = (User)list.get(0);
			 System.out.println("byId------------------------"+user.getId()+user.getName()+user.getMessage());
			 return user;
		 }
			 
		 else
			 return null;
	}


	@Override
	public void changeToAdmin(int Id) {
		// TODO Auto-generated method stub
		User user = getUserById(Id);
		user.setIsAdmin(true);
		getHibernateTemplate().update(user);
	}
}
