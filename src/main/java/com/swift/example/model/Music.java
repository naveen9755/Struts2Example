package com.swift.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = Music.ALL_MUSIC, query = "Select m from Music m") })
@Entity
@Table(name = "Music")
public class Music {

	public static final String ALL_MUSIC = "com.swift.example.model.Music.ALL_MUSIC";

	private Long id;
	private String name;
	private String singer;
	private String album;
	private String composer;
	private String lyricist;
	private Date createOn;

	@Id
	@GeneratedValue
	@Column(name = "MUSIC_ID")
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

	@Column(name = "SINGER")
	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Column(name = "ALBUM")
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Column(name = "COMPOSER")
	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	@Column(name = "LYRICIST")
	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	@Column(name = "CREATED_ON")
	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

}