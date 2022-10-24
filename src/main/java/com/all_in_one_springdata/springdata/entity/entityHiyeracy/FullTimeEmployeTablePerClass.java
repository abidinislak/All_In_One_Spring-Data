package com.all_in_one_springdata.springdata.entity.entityHiyeracy;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeTablePerClass extends EmployeTablePerClass {

    private int salary;

    public FullTimeEmployeTablePerClass() {
    }

    public FullTimeEmployeTablePerClass(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
