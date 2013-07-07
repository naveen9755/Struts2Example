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
		Query query = crudService.findByNameQuery(User.AUTHENTICATE_USER);
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
	public void addUser(User user) {
		try {
			log.info("Inside Add or Update Music Page....");
			if(user.getId() != null) {
				User u1 = this.listUserById(user.getId());
				if(u1 != null) {
					updateUser(user);
				}
			} else {
				log.info("Album: " + user.getUsername());
				crudService.create(user);
			}
		} catch (Exception ex) {
            log.info(ex.getMessage());
            ex.printStackTrace();
        }
	}

	@Override
	public void deleteUser(Long userId) {
		crudService.delete(User.class, userId);
	}

	@Override
	public List<User> listUser() {
		return crudService.findAll(User.GET_ALL_USER);
	}

	@Override
	public User listUserById(Long userId) {
		return crudService.findById(User.class, userId);
	}

	@Override
	public User getUser(String username) {
		Query query = crudService.find(User.GET_USER);
		query.setParameter("username", username);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception ex) {
			log.info("Error: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public void updateUser(User user) {
		log.info("Inside Update Section of User...");
		try {
			log.info("Username: " + user.getUsername());
			crudService.update(user);
			log.info("User Updated...");
		} catch(Exception ex) {
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
