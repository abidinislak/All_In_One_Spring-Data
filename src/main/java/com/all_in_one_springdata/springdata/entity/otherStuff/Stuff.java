package com.all_in_one_springdata.springdata.entity.otherStuff;


import com.all_in_one_springdata.springdata.entity.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
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


    @Id
    @GeneratedValue
    private int id;


    private String name;

    private String category;

    @CreatedDate
    @Column(insertable = true, updatable = false)
    private LocalDate createdDate;

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
