package com.all_in_one_springdata.springdata.entity.otherStuff;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


// just in case of use like updated date end createddate exp
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @LastModifiedDate
    private Date lastModifiedDate;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;
    private String baseEntityValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBaseEntityValue() {
        return baseEntityValue;
    }

    public void setBaseEntityValue(String baseEntityValue) {
        this.baseEntityValue = baseEntityValue;
    }
}
