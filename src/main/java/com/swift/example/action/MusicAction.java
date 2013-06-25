package com.swift.example.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.Music;
import com.swift.example.service.MusicService;

public class MusicAction extends ActionSupport implements ModelDriven<Music>{

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(MusicAction.class.getName());
	
	private Music music = new Music();
	private List<Music> musicList = new ArrayList<Music>();
	@Inject("musicService")
	private MusicService musicService;
	
	public String addMusic() {
		log.info("Music Data: ");
		log.info("Name: " + music.getName());
		log.info("Singer: " + music.getSinger());
		log.info("Album: " + music.getAlbum());
		log.info("Composer: " + music.getComposer());
		log.info("Lyricist: " + music.getLyricist());
		music.setCreateOn(new Date());
		musicService.addMusic(music);
		return SUCCESS;
	}
	
	public String editMusic() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		log.info("Music ID: " + request.getParameter("id"));
		music = musicService.listMusicById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String removeMusic() {
		log.info("Remove Music...");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		log.info("Music ID: " + request.getParameter("id"));
		musicService.removeMusic(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String listMusic() {
		log.info("Size of Music: " + musicService.listMusic().size());
		musicList = musicService.listMusic();
		return SUCCESS;
	}

	@Override
	public Music getModel() {
		return music;
	}
	
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}
}
