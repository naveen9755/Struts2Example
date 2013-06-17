package com.swift.example.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	
	private String username;
	private String password;
	
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
