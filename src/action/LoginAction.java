package action;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.UserService;

public class LoginAction  extends ActionSupport{
	
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
	
	public String UserLogin() {
		
		if(userService.checkUser(user))
			return "input";
		else 
			return "error";		
	}
	
}
