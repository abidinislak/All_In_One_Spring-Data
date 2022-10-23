package com.all_in_one_springdata.springdata.entity.onetoone;


import javax.persistence.*;

@Entity
public class BookDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bookdetailid;
    private String name;

    public BookDetail() {
    }

    public BookDetail(String name) {
        this.name = name;
    }

    public int getBookdetailid() {
        return bookdetailid;
    }

    public void setBookdetailid(int bookdetailid) {
        this.bookdetailid = bookdetailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
