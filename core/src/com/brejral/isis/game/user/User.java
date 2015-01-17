package com.brejral.isis.game.user;

public class User {
	private String name;
	
	public User() {
		this.name = "";
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
