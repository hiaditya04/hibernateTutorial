package javafiles;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 * Author : RAJ 
 */
@Entity
@Table(name="CHILDREN_DATA")
public class Children {
	
	
	private int id;
	
	
	private String name;
	
	
	private int age;

	private Parent parent;
	
	//private Set<SubChildren> childSet;
	
	
	@Id
	@Column(name="CHILD_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="AGE")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	/*@OneToMany(targetEntity=SubChildren.class, cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="CHILD_ID",referencedColumnName="CHILD_ID")
	@Fetch(FetchMode.SUBSELECT)
	public Set<SubChildren> getChildSet() {
		return childSet;
	}
	public void setChildSet(Set<SubChildren> subChildren) {
		this.childSet = subChildren;
	}*/
 
}
