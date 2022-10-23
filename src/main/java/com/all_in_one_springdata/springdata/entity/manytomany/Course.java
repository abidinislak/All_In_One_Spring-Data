package com.all_in_one_springdata.springdata.entity.manytomany;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {


	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String lastname;

	public Course() {
	}


	public Course(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private Set<Student> students=new HashSet<>();
}
