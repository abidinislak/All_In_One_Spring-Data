package com.all_in_one_springdata.springdata.entity.entityHiyeracy;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity

public class PartTimeEmployeTablePerClass extends EmployeTablePerClass {
    private BigDecimal hourlyWage;

    public PartTimeEmployeTablePerClass() {

    }


    public PartTimeEmployeTablePerClass(String asdas, BigDecimal bigDecimal) {


        super(asdas);

        this.hourlyWage = bigDecimal;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}

