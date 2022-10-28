package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.manytomany.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomQueries {
    @Autowired
    EntityManager testEntityManager;

    @Test
    public void testCustomQueries() {
        TypedQuery<Student> query = testEntityManager.createQuery("SELECT s FROM Student s Where s.courses is empty", Student.class);
//        TypedQuery<Student> query = testEntityManager.createQuery("SELECT s FROM Student s Where size(s.courses) >=2", Student.class);
//        TypedQuery<Student> query = testEntityManager.createQuery("SELECT s FROM Student s order by size(s.courses) desc", Student.class);
        List<Student> result = query.getResultList();
        for (var studen :
                result) {
            System.err.println(studen.getName());
        }
    }

    @Test
    public void joinTables() {
//        Query query = testEntityManager.createQuery("SELECT s ,c FROM Student s JOIN s.courses c");
//        Query query = testEntityManager.createQuery("SELECT s ,c FROM Student s LEFT JOIN s.courses c");
        Query query = testEntityManager.createQuery("SELECT s ,c FROM Student s ,Course c");
//        TypedQuery<Student> query = testEntityManager.createQuery("SELECT s FROM Student s Where size(s.courses) >=2", Student.class);
//        TypedQuery<Student> query = testEntityManager.createQuery("SELECT s FROM Student s order by size(s.courses) desc", Student.class);
        List<Object[]> result = query.getResultList();
        for (Object[] resulttemp :
                result) {
            System.err.println(resulttemp[0] + "...." + resulttemp[1]);
        }
    }

    // Criteria Query
    @Test
    public void criteriaQuery() {
//        CriteriaBuilder cb = testEntityManager.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> studentRoot = cq.from(Student.class);
//        Predicate likeJava = cb.like(studentRoot.get("name"), "java");
//
//        cq.where(likeJava);
//        TypedQuery<Student> query = testEntityManager.createQuery(cq.select(studentRoot));
//        List<Student> resultList = query.getResultList();
//        System.err.println(resultList);
//

//        JOİN
        CriteriaBuilder cb = testEntityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> studentRoot = cq.from(Student.class);

        studentRoot.join("courses");


        Join<Object, Object> join = studentRoot.join("courses");


        TypedQuery<Student> query = testEntityManager.createQuery(cq.select(studentRoot));
        List<Student> resultList = query.getResultList();
        System.err.println(resultList);
        resultList.forEach(System.err::println);
    }


}
