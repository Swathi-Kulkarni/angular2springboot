package com.jdriven.ng2boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonInput {
	
	@JsonProperty("user")
	private User data;

	

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}
	
}