package com.swift.example.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.swift.example.serviceimpl.MusicServiceImpl;

public class MusicAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(MusicAction.class.getName());
	
	private MusicServiceImpl musicService = new MusicServiceImpl();
	
	public String addMusic() {
		log.info("Inside Add Music....");
		log.info(musicService.addMusic());
		return SUCCESS;
	}
	
	public String editMusic() {
		log.info("Edit Music: " + musicService.editMusic());
		return SUCCESS;
	}
	
	public String removeMusic() {
		log.info("Remove Music: " + musicService.removeMusic());
		return SUCCESS;
	}
	
	public String listMusic() {
		log.info("Size of Music: " + musicService.listMusic().size());
		for(int i=0; i<musicService.listMusic().size(); i++) {
			log.info("Music: " + musicService.listMusic().get(i));
		}
		return SUCCESS;
	}
}
