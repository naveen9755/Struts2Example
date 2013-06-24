package com.swift.example.service;

import java.util.List;

import com.swift.example.model.Video;

public interface VideoService {
	
	public void addVideo(Video video);
	
	public List<Video> listVideo();
	
	public void removeVideo(Long id);
	
}
