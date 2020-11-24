package com.employee.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "date_of_joining")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name = "is_parmanent")
	private boolean isParmanent;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "profile_pic")
	private String profilePic;
	
	@Column(name = "resume")
	private String resume;
	
	public Employee() {
		
	}
	
	public Employee(String name, double salary, Date dateOfJoining, boolean isParmanent, String designation, String profilePic, String resume) {
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.isParmanent = isParmanent;
		this.designation = designation;
		this.profilePic = profilePic;
		this.resume = resume;
	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isParmanent() {
		return isParmanent;
	}

	public void setParmanent(boolean isParmanent) {
		this.isParmanent = isParmanent;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining
				+ ", isParmanent=" + isParmanent + ", designation=" + designation + ", profilePic=" + profilePic
				+ ", resume=" + resume + "]";
	}
	
}