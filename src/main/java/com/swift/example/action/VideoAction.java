package com.swift.example.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.swift.example.service.VideoService;
import com.swift.example.serviceimpl.VideoServiceImpl;

public class VideoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(VideoAction.class.getName());
	
	private VideoService videoService = new VideoServiceImpl();
	
	public String addVideo() {
		log.info("Inside Add Video....");
		log.info(videoService.addVideo());
		return SUCCESS;
	}
	
	public String editVideo() {
		log.info("Edit Video: " + videoService.editVideo());
		return SUCCESS;
	}
	
	public String removeVideo() {
		log.info("Remove Video: " + videoService.removeVideo());
		return SUCCESS;
	}
	
	public String listVideo() {
		log.info("Size of Music: " + videoService.listVideo().size());
		for(int i=0; i<videoService.listVideo().size(); i++) {
			log.info("Music: " + videoService.listVideo().get(i));
		}
		return SUCCESS;
	}
}
