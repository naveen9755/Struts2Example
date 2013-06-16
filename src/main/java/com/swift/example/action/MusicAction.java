package com.swift.example.action;

import org.apache.log4j.Logger;

import com.swift.example.serviceimpl.MusicServiceImpl;

public class MusicAction {

	private static final Logger log = Logger.getLogger(MusicAction.class.getName());
	
	private MusicServiceImpl musicService;
	
	public String execute() {
		log.info("Inside Music Action...");
		musicService = new MusicServiceImpl();
		log.info(musicService.getName());
		return "music";
	}
}
