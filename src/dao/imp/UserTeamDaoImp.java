package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.UserTeamDao;
import model.UserTeam;

@Transactional(readOnly = false)
public class UserTeamDaoImp extends HibernateDaoSupport implements UserTeamDao {

	@Override
	public void addRelation(int userId, int teamId,int regular) {
		// TODO Auto-generated method stub
		UserTeam userTeam = new UserTeam();
		userTeam.setTeam(teamId);
		userTeam.setUser(userId);
		userTeam.setRegular(regular);
		getHibernateTemplate().save(userTeam);
		
	}

	@Override
	public List getTeamIdOfUser(int userId,int regular) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from UserTeam where user=?0 and regular=?1",userId,regular);
		return list;
	}
	
	public List getUserIdOfTeam(int teamId,int regular) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from UserTeam where team=?0 and regular=?1",teamId,regular);
		return list;
	}
	
	@Override
	public void updateRelation(UserTeam userTeam, int regular) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from UserTeam where user=?0 and team=?1",userTeam.getUser(),userTeam.getTeam());
		userTeam = (UserTeam) list.get(0);
		userTeam.setRegular(regular);
		getHibernateTemplate().update(userTeam);
	}

}
