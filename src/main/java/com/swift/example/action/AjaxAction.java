package com.swift.example.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {

	private static final long serialVersionUID = 2168284470237608719L;
	private String name;

	public String index() {
		return SUCCESS;
	}

	public String resultPage() {
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (StringUtils.isBlank(name)) {
			this.name = "No Contents to Show :(";
		} else {
			this.name =  "You wrote: " + name;
		}
	}
}
