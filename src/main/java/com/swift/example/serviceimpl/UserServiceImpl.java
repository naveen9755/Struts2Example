package com.swift.example.serviceimpl;

import com.swift.example.model.User;
import com.swift.example.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean verifyUser(User user) {
		if(user.getUsername().equals("suraj") && user.getPassword().equals("suraj")) {
			return true;
		}
		return false;
	}

}
