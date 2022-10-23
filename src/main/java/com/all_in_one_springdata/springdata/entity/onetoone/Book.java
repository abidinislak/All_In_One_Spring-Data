package com.all_in_one_springdata.springdata.entity.onetoone;


import javax.persistence.*;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = BookDetail.class)
    @JoinColumn(name = "boook_detail_id",referencedColumnName = "bookdetailid",nullable = true)
    private BookDetail bookDetail;

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
