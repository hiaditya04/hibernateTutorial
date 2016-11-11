package com.training.hibernatedemo.entity;
import java.lang.String;
import java.lang.Integer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="DEMO_PERSON")
public class Person {
	
	private long id;
	
	private String name;
	private String gender;
	private Integer age;
	private String address;
	@Id
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="AGE")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", address=" + address + "]";
	}
	
	
	
	
	

}
