package action;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.UserService;

public class RegisterAction extends ActionSupport{
	User user;
	UserService userService;
	
	 public User getUser() {
	    	return user;
	 }
	public void setUser(User user) {
	    	this.user = user;
	}
	public UserService getUserService() {
    	return userService;
	}
	public void setUserService(UserService userService) {
    	this.userService = userService;
	}
	
	public String userRegister() {
		
			userService.addUser(user);
			return "user";
		
	}
}
