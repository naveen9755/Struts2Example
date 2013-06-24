package com.swift.example.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.swift.example.model.Video;
import com.swift.example.service.VideoService;
import com.swift.example.serviceimpl.VideoServiceImpl;

public class VideoAction extends ActionSupport implements ModelDriven<Video>{
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(VideoAction.class.getName());
	
	private List<Video> videoList = new ArrayList<Video>();
	private Video video = new Video();
	private VideoService videoService = new VideoServiceImpl();
	
	public String addVideo() {
		log.info("Inside Add Video....");
		videoService.addVideo(video);
		return SUCCESS;
	}
	
	public String editVideo() {
		log.info("Edit Video ");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		video = videoService.getVideo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String removeVideo() {
		log.info("Remove Video");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		videoService.removeVideo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String listVideo() {
		log.info("Size of Music: " + videoService.listVideo().size());
		for(int i=0; i<videoService.listVideo().size(); i++) {
			log.info("Music: " + videoService.listVideo().get(i));
		}
		videoList = videoService.listVideo();
		return SUCCESS;
	}

	@Override
	public Video getModel() {
		return video;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<Video> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

}
