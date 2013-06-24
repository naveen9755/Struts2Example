package com.swift.example.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.swift.example.model.Video;
import com.swift.example.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private static final Logger log = Logger.getLogger(VideoServiceImpl.class.getName());
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public VideoServiceImpl() {
		this.emf = Persistence.createEntityManagerFactory("PU_STRUTS");
		this.em = this.emf.createEntityManager();
	}
	
	@Override
	public void addVideo(Video video) {
		log.info("Adding Videos...");
		try {
			this.em.getTransaction().begin();
			this.em.persist(video);
			this.em.flush();
			this.em.refresh(video);
			this.em.getTransaction().commit();
			log.info("Video Added....");
		} catch(Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> listVideo() {
		return this.em.createQuery("from Video").getResultList();
	}

	@Override
	public void removeVideo(Long id) {
		log.info("Removing Videos");
		try {
			this.em.getTransaction().begin();
			Video video	= this.em.getReference(Video.class, id);
			this.em.remove(video);
			this.em.flush();
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			log.info("Inside Remove Exception of Persistence API....");
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
