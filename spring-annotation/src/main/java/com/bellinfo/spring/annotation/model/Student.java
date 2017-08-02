package com.bellinfo.spring.annotation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Student {

	@Size(min=4, max=15)
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
}
