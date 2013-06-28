package com.swift.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FileMgmt")
public class FileMgmt {
	
	private Long id;
	private String imageFile;
	private String contentImageType;
	private String filePath;
	private Date createdOn;
	
	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "IMAGE_FILE")
	public String getImageFile() {
		return imageFile;
	}
	
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Column(name = "CONTENT_IMAGE_TYPE")
	public String getContentImageType() {
		return contentImageType;
	}

	public void setContentImageType(String contentImageType) {
		this.contentImageType = contentImageType;
	}
	
	@Column(name = "FILE_PATH")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
