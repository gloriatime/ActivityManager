package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.TeamDao;
import model.Team;
import model.User;
import model.UserTeam;

@Transactional(readOnly = false)
public class TeamDaoImp extends HibernateDaoSupport implements TeamDao{

	@Override
	public int addTeam(Team team) {
		// TODO Auto-generated method stub
		
		// ·µ»ØteamµÄId
		List list = getHibernateTemplate().find("select Id from Team order by Id desc");
		System.out.println("team------------------------------"+list.get(0));
		 if(list.size()>0) {
			 
			 team.setId((int)list.get(0)+1);
			 getHibernateTemplate().save(team);
			 
			 return (int)list.get(0)+1;
		 }else 
			 return 0;
	}

	@Override
	public Team getTeamById(int Id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("from Team where Id=?0",Id);

		 if(list.size()>0) {

			 Team t = (Team)list.get(0);
			 t.setMemberNum(t.getMemberList().size());
			 return t;
		 }else 
			 return null;
	}


}
