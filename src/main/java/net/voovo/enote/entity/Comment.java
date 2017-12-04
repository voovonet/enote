package net.voovo.enote.entity;

import javax.validation.constraints.NotNull;

public class Comment {

	@NotNull
	private String id;
	
	private String text;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
