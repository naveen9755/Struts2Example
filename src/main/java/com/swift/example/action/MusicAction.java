package com.swift.example.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.swift.example.serviceimpl.MusicServiceImpl;

public class MusicAction implements Action {

	private static final Logger log = Logger.getLogger(MusicAction.class.getName());
	
	private MusicServiceImpl musicService;
	
	public String execute() {
		log.info("Inside Music Action...");
		musicService = new MusicServiceImpl();
		log.info(musicService.getName());
		return SUCCESS;
	}
}
