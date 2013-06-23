package com.swift.example.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.swift.example.model.User;
import com.swift.example.service.UserService;
import com.swift.example.serviceimpl.UserServiceImpl;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService = new UserServiceImpl();
	
	public void validate() {
		if(StringUtils.isEmpty(user.getUsername())) {
			addFieldError("username", "Username cannot be blank");
		}
		
		if(StringUtils.isEmpty(user.getPassword())) {
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	public String execute() {
		if(userService.verifyUser(user)) {
			return SUCCESS;
		}
		addFieldError("username", "Invalid Username and Password...");
		return LOGIN;
	}
	
	@Override
	public User getModel() {
		return user;
	}
}
