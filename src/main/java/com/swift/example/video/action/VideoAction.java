package com.swift.example.video.action;

import org.apache.log4j.Logger;

public class VideoAction {
	
	private static final Logger log = Logger.getLogger(VideoAction.class.getName());
	
	public String execute() {
		log.info("Success Page...");
		return "SUCCESS";
	}

}
