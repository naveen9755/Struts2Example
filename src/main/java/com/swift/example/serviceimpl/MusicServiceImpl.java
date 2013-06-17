package com.swift.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.swift.example.service.MusicService;

public class MusicServiceImpl implements MusicService {

	private static final Logger log = Logger.getLogger(MusicServiceImpl.class.getName());

	@Override
	public long addMusic() {
		log.info("One rows affected");
		return 1;
	}

	@Override
	public List<String> listMusic() {
		List<String> music = new ArrayList<String>();
		music.add("Rock");
		music.add("Jazz");
		music.add("Pop");
		return music;
	}

	@Override
	public boolean removeMusic() {
		log.info("Removing music");
		return true;
	}

	@Override
	public long editMusic() {
		log.info("inside edit music");
		return 2;
	}
}
