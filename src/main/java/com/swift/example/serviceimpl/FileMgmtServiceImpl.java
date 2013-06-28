package com.swift.example.serviceimpl;

import java.util.List;

import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.FileMgmt;
import com.swift.example.service.CrudService;
import com.swift.example.service.FileMgmtService;

public class FileMgmtServiceImpl implements FileMgmtService {

	@Inject("crud")
	private CrudService crudService;
	
	@Override
	public void addFile(FileMgmt file) {
		crudService.create(file);
	}

	@Override
	public List<FileMgmt> listFiles() {
		return crudService.findAll("from FileMgmt");
	}

	@Override
	public void removeFile(Long id) {
		crudService.delete(FileMgmt.class, id);
	}

	@Override
	public FileMgmt getFileById(Long id) {
		return crudService.findById(FileMgmt.class, id);
	}
}