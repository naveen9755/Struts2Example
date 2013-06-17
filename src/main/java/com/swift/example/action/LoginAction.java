package com.swift.example.action;

public class LoginAction {
	
	private String username;
	private String password;
	
	public String execute() {
		if(getUsername().equals("suraj") && getPassword().equals("suraj")) {
			return "success";
		}
		return "failure";
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
