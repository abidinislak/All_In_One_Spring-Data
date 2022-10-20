package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.manytomany.Student;
import com.all_in_one_springdata.springdata.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestStudentRpository
{



	@Autowired
	StudentRepository repo;


	@Autowired
	TestEntityManager emanger;



	@Test
	public void testStudentSave(){
		Student saveStduent=new Student(    "name student","lanst namse test stduent");



		assertThat(repo.save(saveStduent).getId()).isGreaterThan(0);




	}

}
