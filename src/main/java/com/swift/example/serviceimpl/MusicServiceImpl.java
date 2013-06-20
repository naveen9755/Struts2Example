package com.swift.example.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.swift.example.model.Music;
import com.swift.example.service.MusicService;

public class MusicServiceImpl implements MusicService {

	private static final Logger log = Logger.getLogger(MusicServiceImpl.class.getName());

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public MusicServiceImpl() {
		this.emf = Persistence.createEntityManagerFactory("PU_STRUTS");
		this.em = emf.createEntityManager();
	}
	
	
	@Override
	public void addMusic(Music music) throws SecurityException {
		try {
			log.info("Album: " + music.getAlbum());
			this.em.getTransaction().begin();
			this.em.persist(music);
			this.em.flush();
			this.em.refresh(music);
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
            log.info("Inside Persist Exception....");
            log.info(ex.getMessage());
            ex.printStackTrace();
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Music> listMusic() {
        try {
            return this.em.createQuery("from Music").getResultList();
        } finally {
            em.close();
        }
	}

	@Override
	public void removeMusic(Long id) {
		
	}

	@Override
	public void updateMusic(Music music) {
		log.info("inside edit music");
	}
}
