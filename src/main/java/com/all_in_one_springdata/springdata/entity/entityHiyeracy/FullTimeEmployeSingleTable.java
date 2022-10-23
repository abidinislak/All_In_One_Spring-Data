package com.all_in_one_springdata.springdata.entity.entityHiyeracy;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeSingleTable extends EmployeSingleTable{

    public FullTimeEmployeSingleTable() {
    }

    public FullTimeEmployeSingleTable(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
