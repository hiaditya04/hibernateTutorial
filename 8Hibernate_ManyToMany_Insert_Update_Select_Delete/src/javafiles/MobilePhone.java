package javafiles;

import java.util.Set;

public class MobilePhone {
	
	private int id;
	private int modelNumber;
	private String name;
	private Set users;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getUsers() {
		return users;
	}
	public void setUsers(Set users) {
		this.users = users;
	}		
}
