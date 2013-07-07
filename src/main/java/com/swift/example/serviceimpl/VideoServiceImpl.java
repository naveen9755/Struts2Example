package com.swift.example.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.model.Video;
import com.swift.example.service.CrudService;
import com.swift.example.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private static final Logger log = Logger.getLogger(VideoServiceImpl.class
			.getName());

	@Inject("crud")
	private CrudService crudService;

	@Override
	public void addVideo(Video video) {
		log.info("Inside Add or Update Music Page....");
		try {
			if (video.getId() != null) {
				Video v1 = this.getVideo(video.getId());
				if (v1 != null) {
					log.info("Updating the Video....");
					crudService.update(video);
				}
			} else {
				crudService.create(video);
				log.info("Video Added....");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Video> listVideo() {
		return crudService.findAll(Video.ALL_VIDEOS);
	}

	@Override
	public void removeVideo(Long id) {
		log.info("Removing Videos");
		try {
			crudService.delete(Video.class, id);
		} catch (Exception ex) {
			log.info(ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public Video getVideo(Long id) {
		return crudService.findById(Video.class, id);
	}
}
