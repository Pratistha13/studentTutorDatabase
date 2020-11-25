package com.example.studentTutorDatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Tutor> tutors;
	
	public Department() {
		super();
	}
	
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Long getDepartmentid() {
		return departmentid;
	}
	
	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Tutor> gettutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

}