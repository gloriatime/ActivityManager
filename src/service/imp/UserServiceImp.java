package service.imp;

import dao.UserDao;
import model.User;
import service.UserService;

public class UserServiceImp implements UserService{
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}
	@Override
	public User getUserById(int Id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(Id);
	}
	@Override
	public void changeToAdmin(int Id) {
		// TODO Auto-generated method stub
		userDao.changeToAdmin(Id);
	}


}
