package com.all_in_one_springdata.springdata.entity.entityHiyeracy;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity

public class PartTimeEmployeSingleTable extends EmployeSingleTable{
private BigDecimal hourlyWage;

    public PartTimeEmployeSingleTable() {

    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public PartTimeEmployeSingleTable(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}

