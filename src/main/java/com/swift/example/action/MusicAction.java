package com.swift.example.action;

import org.apache.log4j.Logger;

public class MusicAction {

	private static final Logger log = Logger.getLogger(MusicAction.class.getName());
	
	public String execute() {
		log.info("Inside Music Action...");
		return "music";
	}
}
