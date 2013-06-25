package com.swift.example.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.Video;
import com.swift.example.service.VideoService;

public class VideoAction extends ActionSupport implements ModelDriven<Video>{
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(VideoAction.class.getName());
	
	private List<Video> videoList = new ArrayList<Video>();
	private Video video = new Video();
	@Inject("videoService")
	private VideoService videoService;
	
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
		log.info("Size of Video: " + videoService.listVideo().size());
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
