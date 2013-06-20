package com.swift.example.serviceimpl;

import java.util.List;

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

	@Override
	public void saveOrUpdateUser(User user) {
		
	}

	@Override
	public void deleteUser(Long userId) {
		
	}

	@Override
	public List<User> listUser() {
		return null;
	}

	@Override
	public User listUserById(Long userId) {
		return null;
	}
}
