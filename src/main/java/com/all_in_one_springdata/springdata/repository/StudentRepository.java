package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.manytomany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
