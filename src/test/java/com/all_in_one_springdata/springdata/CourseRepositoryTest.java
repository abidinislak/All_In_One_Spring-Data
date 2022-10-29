package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.manytomany.Course;
import com.all_in_one_springdata.springdata.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;
import java.util.List;

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

//        emanager.persist(new Course("aaa", "aaa"));
//        emanager.persist(new Course("bb", "bbb"));
//        emanager.persist(new Course("ccc", "cdcd"));
//        emanager.persist(new Course("ddd", "ccc"));
//
//
//        repo.save(new Course("wda", "wqeqwe"));


    }


    //    Solving n+1 problem
//    first metod tosolve is fetch type eager
//    second metod isthis metdo
//            3nd metod is typeign join ge-fect sql named crating
//    3nd metod query "select  c From Course JOIN FETCH c.students"
    @Test
    @Transactional
    public void solvingPlusOneProblem_EntityGraph() {
        EntityGraph<Course> entityGraph = emanager.createEntityGraph(Course.class);
        Subgraph<Object> subgraph = entityGraph.addSubgraph("students");

        List<Course> courses = emanager.createNamedQuery("query_get_all_courses", Course.class).setHint("javax.persistence.loadgraph", entityGraph).getResultList();
        for (Course course :
                courses) {
            System.err.println(".." + course + "+++" + course.getStudents());
        }

    }


}
