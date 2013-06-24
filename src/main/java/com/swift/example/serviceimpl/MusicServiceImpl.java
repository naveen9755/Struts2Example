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
			log.info("Inside Add or Update Music Page....");
			if(music.getId() != null) {
				this.em.getTransaction().begin();
				Music m1 = this.listMusicById(music.getId());
				this.em.getTransaction().commit();
				if(m1 != null) {
					updateMusic(music);
				}
			} else {
				log.info("Album: " + music.getAlbum());
				this.em.getTransaction().begin();
				this.em.persist(music);
				this.em.flush();
				this.em.refresh(music);
				this.em.getTransaction().commit();
			}
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
		return this.em.createQuery("from Music").getResultList();
	}

	@Override
	public void removeMusic(Long id) {
		try {
			this.em.getTransaction().begin();
			Music music	= this.em.getReference(Music.class, id);
			this.em.remove(music);
			this.em.flush();
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			log.info("Inside Remove Exception of Persistence API....");
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public void updateMusic(Music music) {
		log.info("inside edit music");
		try {
			log.info("Music Singer: " + music.getSinger());
			this.em.getTransaction().begin();
			this.em.merge(music);
			this.em.flush();
			this.em.getTransaction().commit();
			log.info("Music Updated...");
		} catch(Exception ex) {
			this.em.getTransaction().rollback();
			log.info("Inside Update Exception of Persistence API....");
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}


	@Override
	public Music listMusicById(Long id) {
		Music music = null;
		try {
			music = this.em.getReference(Music.class, id);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return music;
	}
}
