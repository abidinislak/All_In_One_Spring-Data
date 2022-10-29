package com.all_in_one_springdata.springdata.entity.manytomany;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c")


})
public class Course {

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private final Set<Student> students = new HashSet<>();
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastname;

    public Course() {
    }

    public Course(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);

    }

    public void removeStudent(Student student) {
        this.students.remove(student);

    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
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
