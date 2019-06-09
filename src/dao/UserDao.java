package dao;

import org.springframework.transaction.annotation.Transactional;

import model.User;


public interface UserDao {
	
  public void addUser(User user);
  
  public boolean checkUser(User user);
  
  public User getUserById(int Id);
  
  public void changeToAdmin(int Id);
  
  public void update(User user);
}
