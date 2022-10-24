package com.all_in_one_springdata.springdata.entity.entityHiyeracy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeTablePerClass {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;

    public EmployeTablePerClass() {
    }

    public EmployeTablePerClass(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
