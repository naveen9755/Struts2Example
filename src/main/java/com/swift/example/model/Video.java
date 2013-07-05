package com.swift.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callVideoStoreProcedure",
	query = "select list_all_singer_names()",
	resultClass = Video.class
	)
})
@Entity
@Table(name = "Video")
public class Video {
	
	private Long id;

	private String name;
	
	private String actor;
	
	private String director;
	
	private String writer;
	
	private String category;
	
	private Date createdOn;
	
	@Id
	@GeneratedValue
	@Column(name = "VIDEO_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ACTOR")
	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Column(name = "DIRECTOR")
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(name = "WRITER")
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Column(name = "CATEGORY")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
