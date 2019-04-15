package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.ActTeamDao;
import model.ActTeam;
import model.UserTeam;

@Transactional(readOnly = false)
public class ActTeamDaoImp extends HibernateDaoSupport implements ActTeamDao {

	@Override
	public void addRelation(int actId, int teamId) {
		// TODO Auto-generated method stub
		ActTeam actTeam = new ActTeam();
		actTeam.setActivity(actId);
		actTeam.setTeam(teamId);
		getHibernateTemplate().save(actTeam);
		
	}

	@Override
	public List getTeamIdOfAct(int actId) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from ActTeam where activity=?0",actId);
		return list;
	}

}
