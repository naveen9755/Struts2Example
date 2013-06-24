package com.swift.example.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.swift.example.model.User;
import com.swift.example.service.UserService;

public class UserServiceImpl implements UserService {
	
	private static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UserServiceImpl() {
		this.emf = Persistence.createEntityManagerFactory("PU_STRUTS");
		this.em = emf.createEntityManager();
	}
	
	@Override
	public boolean verifyUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		Query query = this.em.createQuery("Select u from User u where u.username = :username and u.password = :password");
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
		this.em.getTransaction().begin();
		this.em.persist(user);
		this.em.flush();
		this.em.refresh(user);
		this.em.getTransaction().commit();
	}

	@Override
	public void deleteUser(Long userId) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		try {
			return this.em.createQuery("from User").getResultList();
		} finally {
			this.em.close();
		}
	}

	@Override
	public User listUserById(Long userId) {
		User user = null;
		try {
			user = this.em.getReference(User.class, userId);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
}
