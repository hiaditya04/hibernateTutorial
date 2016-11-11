package javafiles;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="STUDENTS_DATA")
public class Student {
	
	@Id
	@Column(name="ROLL_NUMBER")
	private int rollNumber;
	
	@Column(name="NAME",length=20)
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
		
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
 }
