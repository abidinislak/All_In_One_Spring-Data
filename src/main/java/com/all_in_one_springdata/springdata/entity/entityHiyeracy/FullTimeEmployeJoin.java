package com.all_in_one_springdata.springdata.entity.entityHiyeracy;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeJoin extends EmployeJoin {

    private int salary;

    public FullTimeEmployeJoin() {
    }

    public FullTimeEmployeJoin(String name, int salary) {
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
