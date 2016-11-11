package com.raj.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TBLM_PARENT")
public class Parent {
	private int id;
	private String name;
	private Set<Child> childs;
	
	@Id
	@Column(name="ID")
	@GenericGenerator(name="employee",strategy="increment")
	@GeneratedValue(generator="employee")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(targetEntity=Child.class,mappedBy ="parent",cascade=CascadeType.ALL,orphanRemoval=false)
	public Set<Child> getChilds() {
		return childs;
	}
	public void setChilds(Set<Child> childs) {
		this.childs = childs;
	}
}
