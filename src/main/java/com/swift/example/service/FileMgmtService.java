package com.swift.example.service;

import java.util.List;

import com.swift.example.model.FileMgmt;

public interface FileMgmtService {

	public void addFile(FileMgmt file);
	
	public List<FileMgmt> listFiles();
	
	public void removeFile(Long id);
	
	public FileMgmt getFileById(Long id);
}
