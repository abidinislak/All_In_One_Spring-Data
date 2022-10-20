package com.all_in_one_springdata.springdata.entity.onetomany;


import javax.persistence.*;

@Entity
public class Person {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;



	private String name;
	private String lastName;


	@ManyToOne(fetch = FetchType.LAZY,optional = true,cascade = CascadeType.ALL)
	@JoinColumn(name="class_id",referencedColumnName = "id",nullable = true)

	private Class ownClass;

	public Class getOwnClass() {
		return ownClass;
	}

	public void setOwnClass(Class ownClass) {
		this.ownClass = ownClass;
	}

	public Integer getId() {

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
