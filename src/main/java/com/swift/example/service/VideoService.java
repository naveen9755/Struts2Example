package com.swift.example.service;

import java.util.List;

public interface VideoService {
	
	public long addVideo();
	
	public List<String> listVideo();
	
	public boolean removeVideo();
	
	public long editVideo();
}
