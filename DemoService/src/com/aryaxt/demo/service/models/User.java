package com.aryaxt.demo.service.models;

import java.io.Serializable;

public class User implements Serializable {
	
    private static final long serialVersionUID = -8856296264601289285L;
	private String login;
	private String avatar_url;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getAvatar_url() {
		return avatar_url;
	}
	
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
}
