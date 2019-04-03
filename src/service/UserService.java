package service;

import model.User;

public interface UserService {
	// 添加用户
	 public void addUser(User user);
	 
	// 查看用户是否存在
	 public boolean checkUser(User user);
	 
	 // 查询用户
	 public User getUserById(int Id);
	 
	 // 更改用户信息
	 public void changeToAdmin(int Id) ;
}
