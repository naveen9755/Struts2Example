package com.swift.example.service;

import java.util.List;

import com.swift.example.model.User;

public interface UserService {
	
	public boolean verifyUser(User user);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);
	
	public List<User> listUser();
	
	public User listUserById(Long userId);
	
	public User getUser(String email);
}
