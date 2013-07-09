package com.swift.example.webservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.business.MusicBO;

@Results({ @Result(name = "success", type = "redirectAction") })
public class MusicController implements ModelDriven<Object>, ServletRequestAware {
	
	private String representation;
	private HttpServletRequest request;
	@Inject("musicBO")
	private MusicBO musicBO;
	private static final Logger log = Logger.getLogger(MusicController.class
			.getName());
	
	// GET /music
	public HttpHeaders execute() {
		log.info("Inside INDEX OF MUSIC CONTROLLER");
		String acceptHeader = request.getHeader("accept");
		log.info("HEADER: " + acceptHeader);
        if(acceptHeader.contains("application/xml")) {
            setRepresentation(musicBO.getAllXML());
        } else if(acceptHeader.equals("application/json")){
            setRepresentation(musicBO.getAllJSON());
        }
        return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public Object getModel() {
		return representation;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
