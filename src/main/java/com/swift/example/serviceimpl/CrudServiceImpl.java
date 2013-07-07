package com.swift.example.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.swift.example.service.CrudService;

public class CrudServiceImpl implements CrudService {
	
	private static final Logger log = Logger.getLogger(CrudServiceImpl.class.getName());
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CrudServiceImpl() {
		this.emf = Persistence.createEntityManagerFactory("PU_STRUTS");
		this.em = emf.createEntityManager();
	}

	@Override
	public <T> T create(T t) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(t);
			this.em.flush();
			this.em.refresh(t);
			this.em.getTransaction().commit();
		} catch(Exception ex) {
			this.em.getTransaction().rollback();
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
		return t;
	}

	@Override
	public <T> T update(T t) {
		try {
			this.em.getTransaction().begin();
			T upT = this.em.merge(t);
			this.em.flush();
			this.em.getTransaction().commit();
			return (T) upT;
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			log.info("Inside Update Exception....");
			log.info(ex.getMessage());
			ex.printStackTrace();
			return t;
		}
	}

	@Override
	public <T> boolean delete(Class<T> type, Object id) {
		try {
			this.em.getTransaction().begin();
			Object object = this.em.find(type, id);
			this.em.remove(object);
			this.em.flush();
			this.em.getTransaction().commit();
			return true;
		} catch(Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
			return false;
		}		
	}

	@Override
	public <T> T findById(Class<T> type, Object id) {
		if (id == null) {
            return null;
        }
        return (T) this.em.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(String query) {
		return this.em.createNamedQuery(query).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(String query) {
		return (T) this.em.createNamedQuery(query);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <T> List findUsingSP(String query) {
		return this.em.createNativeQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T findByNameQuery(String query) {
		return (T) this.em.createNamedQuery(query);
	}

}
