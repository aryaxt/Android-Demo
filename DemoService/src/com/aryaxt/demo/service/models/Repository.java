package com.aryaxt.demo.service.models;

import java.io.Serializable;

public class Repository implements Serializable {

	private static final long serialVersionUID = 556264717191311604L;
	private int id;
	private String name;
	private String description;
	private User owner;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User author) {
		this.owner = author;
	}
}
