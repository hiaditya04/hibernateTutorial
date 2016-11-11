package javafiles;

/*
 * Author : RAJ 
 */
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="PARENTS_DATA")
public class Parent {
	
	
	private int id;
	
	
	private String name;
	
	private Set children;
	
	@Id
	@Column(name="PARENT_ID")
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
	
	@OneToMany(targetEntity=Children.class,mappedBy ="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	//@JoinColumn(name="PARENT_ID",referencedColumnName="PARENT_ID")
	@Fetch(FetchMode.SUBSELECT)
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}	
}
