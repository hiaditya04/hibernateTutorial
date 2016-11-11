package javafiles;

import java.io.Serializable;

public class Creature implements Serializable{

	private int Id;
	private String Name;
	private String color;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	 
}