package com.swift.example.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.User;
import com.swift.example.service.CrudService;
import com.swift.example.service.UserService;

public class UserServiceImpl implements UserService {
	
	private static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Inject("crud")
	private CrudService crudService;
	
	@Override
	public boolean verifyUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		Query query = crudService.find("Select u from User u where u.username = :username and u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		try {
			if(query.getSingleResult() != null)
				return true;
			return false;
		} catch(Exception ex) {
			log.info(ex.getMessage());
			return false;
		}
	}

	@Override
	public void saveOrUpdateUser(User user) {
		crudService.create(user);
	}

	@Override
	public void deleteUser(Long userId) {
		crudService.delete(User.class, userId);
	}

	@Override
	public List<User> listUser() {
		return crudService.findAll("from User");
	}

	@Override
	public User listUserById(Long userId) {
		return crudService.findById(User.class, userId);
	}
}
