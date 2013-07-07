package com.swift.example.service;

import java.util.List;

public interface CrudService {
	
	public <T> T create(T t);
	
	public <T> T update(T t);
	
	public <T> boolean delete(Class<T> type, Object id);
	
	public <T> T findById(Class<T> type, Object id);
	
	public <T> List<T> findAll(String query);
	
	public <T> T find(String query);
	
	@SuppressWarnings("rawtypes")
	public <T> List findUsingSP(String query);
	
	public <T> T findByNameQuery(String query);
}
