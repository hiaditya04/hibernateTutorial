package javafiles;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name="SUB_CHILDREN_DATA")
public class SubChildren {
    
	private int id;
	
	private String name;
	
	
	private int age;

	private Children children;
	
	@Id
	@Column(name="SUB_CHILD_ID")
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
	@JoinColumn(name="CHILD_ID")
	@Transient
	public Children getChildren() {
		return children;
	}
	public void setChildren(Children children) {
		this.children = children;
	}
	
	/*@ManyToOne
	@JoinColumn(name="CHILD_ID")
	@Transient*/
	
 
	
}
