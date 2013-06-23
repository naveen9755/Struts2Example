package com.swift.example.service;

import java.util.List;

import com.swift.example.model.Music;

public interface MusicService {
	
	public void addMusic(Music music);
	
	public List<Music> listMusic();
	
	public void removeMusic(Long id);
	
	public void updateMusic(Music music);
	
	public Music listMusicById(Long id);
}
