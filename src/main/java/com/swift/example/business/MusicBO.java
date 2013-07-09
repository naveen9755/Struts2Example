package com.swift.example.business;

import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.service.MusicService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class MusicBO {

	@Inject("musicService")
	private MusicService musicService;

	public String getAllXML() {
		XStream xStream = new XStream();
		String xml = xStream.toXML(musicService.listMusic());
		return xml;
	}

	public String getAllJSON() {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		String json = xstream.toXML(musicService.listMusic());
		return json;
	}
}