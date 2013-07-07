package com.swift.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = User.AUTHENTICATE_USER, query = "Select u from User u where u.username = :username and u.password = :password"),
		@NamedQuery(name = User.GET_ALL_USER, query = "Select u from User u"),
		@NamedQuery(name = User.GET_USER, query = "Select u from User u where u.username = :username"), })
@Entity
@Table(name = "Users")
public class User {

	public static final String AUTHENTICATE_USER = "com.swift.example.model.User.AUTHENTICATE_USER";
	public static final String GET_ALL_USER = "com.swift.example.model.User.GET_ALL_USER";
	public static final String GET_USER = "com.swift.example.model.User.GET_USER";
	private Long id;
	private String username;
	private String password;
	private Date created_on;
	private Date modified_on;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CREATED_ON")
	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	@Column(name = "MODIFIED_ON")
	public Date getModified_on() {
		return modified_on;
	}

	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}
}
