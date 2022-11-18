package com.all_in_one_springdata.springdata.entity.otherStuff;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)

//Awseome of  spring data,,,, SOFT DELETE
@SQLDelete(sql = "update stuff set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Stuff extends BaseEntity {


    private String name;

    private String category;


    @LastModifiedDate
    @Column(insertable = false, updatable = true)
    private LocalDate updatedDate;

    @Embedded
    private Addressss adres;

    @Enumerated
    private StuffType type;
    private boolean isDeleted;

    public Stuff() {
    }

    public Addressss getAdres() {
        return adres;
    }

    public void setAdres(Addressss adres) {
        this.adres = adres;
    }

    @PreRemove
    private void preRemove() {


        System.err.println("deleteidng");
        this.isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
