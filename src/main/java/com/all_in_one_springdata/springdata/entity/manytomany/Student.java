package com.all_in_one_springdata.springdata.entity.manytomany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)

//@NamedQueries({
//		@NamedQuery(name="one",query = "?"),
//		@NamedQuery(name="one",query = "?")
//})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Student.findNameNative", query = "select count(*) as cnt from springdata.student where name=:name", resultSetMapping = "SqlResultSetMapping.count")
})
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})

//  Spring data jpa doesnt support dynamic sorting for native queires
@Repository


public class Student {


    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String lastname;

    private String updateDbModule;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_courses", joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "coorse_id", referencedColumnName = "id")})

    private Set<Course> courses = new HashSet<>();
    @CreatedDate
    private LocalDate createdDate;

    public Student() {
    }

    public Student(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getUpdateDbModule() {
        return updateDbModule;
    }

    public void setUpdateDbModule(String updateDbModule) {
        this.updateDbModule = updateDbModule;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }


    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
