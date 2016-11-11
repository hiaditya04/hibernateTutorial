package com.raj.pojo;

import java.util.Set;

public class Parent {
	private int id;
	private String name;
	private Set<Child> childs;
	
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
	public Set<Child> getChilds() {
		return childs;
	}
	public void setChilds(Set<Child> childs) {
		this.childs = childs;
	}
}
