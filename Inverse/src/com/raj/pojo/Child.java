package com.raj.pojo;
 
public class Child {
	
	private int id;
	private String name;
	private int age;
	private int parentId;
	private Parent parent;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
 
	public Parent getParent() {
		return parent;
	}
 
	public void setParent(Parent parent) {
		this.parent = parent;
	}
		
}
