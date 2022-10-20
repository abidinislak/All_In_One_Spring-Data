package com.all_in_one_springdata.springdata.entity.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student
{


	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String lastname;


	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(name = "student_courses",joinColumns = {@JoinColumn (name = "student_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "coorse_id",referencedColumnName = "id")})

	private Set<Course> courses=new HashSet<>();


	public Student() {
	}





	public Student(String name, String lastname) {
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
}
