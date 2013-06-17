package com.swift.example.service;

import java.util.List;

public interface MusicService {
	
	public long addMusic();
	
	public List<String> listMusic();
	
	public boolean removeMusic();
	
	public long editMusic();
}
