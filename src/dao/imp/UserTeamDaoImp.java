package dao.imp;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.UserTeamDao;
import model.UserTeam;

@Transactional(readOnly = false)
public class UserTeamDaoImp extends HibernateDaoSupport implements UserTeamDao {

	@Override
	public void addMember(UserTeam ut) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ut);
	}

}
