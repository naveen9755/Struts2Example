package com.swift.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.swift.example.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private static final Logger log = Logger.getLogger(VideoServiceImpl.class.getName());
	
	@Override
	public long addVideo() {
		log.info("One rows affected");
		return 1;
	}

	@Override
	public List<String> listVideo() {
		List<String> videos = new ArrayList<String>();
		videos.add("Comedy");
		videos.add("Action");
		videos.add("Romance");
		return videos;
	}

	@Override
	public boolean removeVideo() {
		log.info("Removing Videos");
		return true;
	}

	@Override
	public long editVideo() {
		log.info("Inside edit Videos");
		return 2;
	}

}
