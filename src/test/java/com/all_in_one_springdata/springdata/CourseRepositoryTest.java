package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.manytomany.Course;
import com.all_in_one_springdata.springdata.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CourseRepositoryTest {


    @Autowired
    CourseRepository repo;
    @Autowired
    EntityManager emanager;

    @Test
    public void playwithCourse() {

        emanager.persist(new Course("aaa", "aaa"));
        emanager.persist(new Course("bb", "bbb"));
        emanager.persist(new Course("ccc", "cdcd"));
        emanager.persist(new Course("ddd", "ccc"));


        repo.save(new Course("wda", "wqeqwe"));


    }


}
