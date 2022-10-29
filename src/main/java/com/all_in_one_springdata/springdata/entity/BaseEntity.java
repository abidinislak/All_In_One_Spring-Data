package com.all_in_one_springdata.springdata.entity;

import javax.persistence.MappedSuperclass;


// just in case of use like updated date end createddate exp
@MappedSuperclass
public class BaseEntity {

    private String baseEntityValue;

    public String getBaseEntityValue() {
        return baseEntityValue;
    }

    public void setBaseEntityValue(String baseEntityValue) {
        this.baseEntityValue = baseEntityValue;
    }
}
