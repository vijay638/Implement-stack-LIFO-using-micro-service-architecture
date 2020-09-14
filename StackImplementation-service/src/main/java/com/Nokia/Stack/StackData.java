package com.Nokia.Stack;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StackData {

	@JsonIgnore
	private Long id;

	private int data;
	
	public StackData() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
}
