package com.gymSystem.model;

public class Participants {
	public String name;
		
	public Participants() {
		
	}
	
	public Participants(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Participants [name=" + name + "]";
	}
}