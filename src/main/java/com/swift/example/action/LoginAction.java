package com.swift.example.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.User;
import com.swift.example.service.UserService;

public class LoginAction extends ActionSupport implements ModelDriven<User>, SessionAware {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginAction.class.getName());
	private User user = new User();
	@Inject("users")
	private UserService userService;
	private Map<String, Object> session;
	
	public String login() {
		if(userService.verifyUser(user)) {
			this.session.put("loggedInUser", user.getUsername());
			return SUCCESS;
		}
		addFieldError("username", "Invalid Username and Password...");
		return LOGIN;
	}
	
	public String logout() {
		log.info("Logged out successfully...");
		this.session.remove("loggedInUser");
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
}
