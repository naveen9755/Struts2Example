package com.swift.example.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public void validate() {
		if(StringUtils.isEmpty(getUsername())) {
			addFieldError("username", "Username cannot be blank");
		}
		
		if(StringUtils.isEmpty(getPassword())) {
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	public String execute() {
		if(getUsername().equals("suraj") && getPassword().equals("suraj")) {
			return SUCCESS;
		}
		return LOGIN;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
