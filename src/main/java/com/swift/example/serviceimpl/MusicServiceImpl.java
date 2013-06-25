package com.swift.example.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.Music;
import com.swift.example.service.CrudService;
import com.swift.example.service.MusicService;

public class MusicServiceImpl implements MusicService {

	private static final Logger log = Logger.getLogger(MusicServiceImpl.class.getName());
	
	@Inject("crud")
	private CrudService crudService;
	
	@Override
	public void addMusic(Music music) throws SecurityException {
		try {
			log.info("Inside Add or Update Music Page....");
			if(music.getId() != null) {
				Music m1 = this.listMusicById(music.getId());
				if(m1 != null) {
					updateMusic(music);
				}
			} else {
				log.info("Album: " + music.getAlbum());
				crudService.create(music);
			}
		} catch (Exception ex) {
            log.info("Inside Persist Exception....");
            log.info(ex.getMessage());
            ex.printStackTrace();
        }
	}

	@Override
	public List<Music> listMusic() {
		return crudService.findAll("from Music");
	}

	@Override
	public void removeMusic(Long id) {
		try {
			crudService.delete(Music.class, id);
		} catch (Exception ex) {
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
			crudService.update(music);
			log.info("Music Updated...");
		} catch(Exception ex) {
			log.info("Inside Update Exception of Persistence API....");
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public Music listMusicById(Long id) {
		return crudService.findById(Music.class, id);
	}
}
