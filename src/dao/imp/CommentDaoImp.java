package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import dao.CommentDao;
import dao.TeamCommentDao;
import model.Comment;
import model.Team;
import model.TeamComment;
import model.User;

@Transactional(readOnly = false)
public class CommentDaoImp extends HibernateDaoSupport implements CommentDao {

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		User user = new User();
		user = (User)ActionContext.getContext().getSession().get("user");
		comment.setCritic(user.getId());
		getHibernateTemplate().save(comment);
	}

	@Override
	public List<Comment> getCommentByCriticId(int Id) {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) getHibernateTemplate().find("from Comment where critic=?0",Id);
		return list;
	}
	
	@Override
	public List<Comment> getCommentByActivityId(int Id) {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) getHibernateTemplate().find("from Comment where belong=?0",Id);
		return list;
	}

	@Override
	public void deleteCommentById(int Id) {
		// TODO Auto-generated method stub
		Comment c = new Comment();
		c.setId(Id);
		getHibernateTemplate().delete(c);

	}

}
