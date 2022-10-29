package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.manytomany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    //	@Query("SELECT c FROM Student c WHERE c.name= ?1")
    @Query(value = "SELECT id, lastname, name, created_date FROM springdata.student where name=:name", nativeQuery = true)
    List<Student> findByName(String name);


    @Transactional
    @Modifying
    @Query("UPDATE   Student s SET s.name=?1 where s.id > ?2")
    int updateNameById(@Param("name") String name, int id);


    @Query(nativeQuery = true)
    int findNameNative(@Param("name") String name);


}
