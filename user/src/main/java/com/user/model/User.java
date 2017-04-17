package com.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("salary")
	private Integer salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
