package com.all_in_one_springdata.springdata.entity.onetomany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Class {

	public Class(String name) {
		this.name = name;
	}

	public Class() {
	}

@OneToMany(mappedBy = "ownClass",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Person.class)
private Set<Person> persons;

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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

	public String getAlias() {
		return alias;
	}

	@Override
	public String toString() {
		return " ..................";
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}



//	private Set<Person> persons;
	private String name;
	private String alias;
}
