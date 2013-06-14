package com.swift.example.action;

import org.apache.log4j.Logger;

import com.swift.example.serviceimpl.VideoServiceImpl;

public class VideoAction {
	
	private static final Logger log = Logger.getLogger(VideoAction.class.getName());
	
	private String name;
	private VideoServiceImpl videoService;
	
	public String execute() {
		log.info("Success Page...");
		videoService = new VideoServiceImpl();
		setName(videoService.getName());
		log.info("Name of Video: " + videoService.getName());
		return "SUCCESS";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
