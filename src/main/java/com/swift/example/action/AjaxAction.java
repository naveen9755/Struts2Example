package com.swift.example.action;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport{
	
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
		this.name = name;
	}
}
