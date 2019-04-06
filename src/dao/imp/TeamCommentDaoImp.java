package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.TeamCommentDao;
import model.Team;
import model.TeamComment;

@Transactional(readOnly = false)
public class TeamCommentDaoImp extends HibernateDaoSupport implements TeamCommentDao {

	@Override
	public void addTeamComment(TeamComment teamComment) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().save(teamComment);
	}

	@Override
	public List<TeamComment> getTeamCommentByTeamId(int Id) {
		// TODO Auto-generated method stub
		List<TeamComment> list = (List<TeamComment>) getHibernateTemplate().find("from TeamComment where team=?0",Id);
		return list;
	}
	
	@Override
	public List<TeamComment> getTeamCommentByActivityId(int Id) {
		// TODO Auto-generated method stub
		List<TeamComment> list = (List<TeamComment>) getHibernateTemplate().find("from TeamComment where belong=?0",Id);
		return list;
	}

	@Override
	public void deleteTeamCommentById(int Id) {
		// TODO Auto-generated method stub
		TeamComment tc = new TeamComment();
		tc.setId(Id);
		getHibernateTemplate().delete(tc);

	}

}
