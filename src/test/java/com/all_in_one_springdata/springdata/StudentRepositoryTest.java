package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.manytomany.Student;
import com.all_in_one_springdata.springdata.repository.CourseRepository;
import com.all_in_one_springdata.springdata.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {


    @Autowired
    StudentRepository repo;


    @Autowired
    CourseRepository courseRepo;

    @Test
    public void testStudent() {

        Student saveStudent = new Student();
        saveStudent.setName("java");


        repo.save(saveStudent);

        assertThat(saveStudent.getId()).isGreaterThan(0);


    }
}
