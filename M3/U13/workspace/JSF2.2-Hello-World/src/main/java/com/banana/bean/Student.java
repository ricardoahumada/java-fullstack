package com.banana.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
