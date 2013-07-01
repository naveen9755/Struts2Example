package com.swift.example.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.User;
import com.swift.example.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 640996836030354264L;
	private static final Logger log = Logger.getLogger(UserAction.class.getName());
	
	@Inject("users")
	private UserService userService;
	private User user = new User();
	private List<User> userList = new ArrayList<User>();
	
	public String listUser() {
		log.info("List the users");
		userList = userService.listUser();
		return SUCCESS;
	}
	
	public String addUser() {
		log.info("Username: " + user.getUsername());
		log.info("Password: " + user.getPassword());
		user.setCreated_on(new Date());
		user.setModified_on(new Date());
		userService.addUser(user);
		return SUCCESS;
	}
	
	public String editUser() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		log.info("User ID: " + request.getParameter("id"));
		user = userService.listUserById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String removeUser() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		log.info("User ID: " + request.getParameter("id"));
		userService.deleteUser(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}