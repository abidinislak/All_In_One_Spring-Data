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

import java.util.List;

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
		Student saveStduent=new Student(    "bolu denmee son ","reposirtoy bug");



		assertThat(repo.save(saveStduent).getId()).isGreaterThan(0);




	}

	@Test
	public void testListStuduent(){
		System.err.println("............................................");

		System.out.println("..........");

		List<Student> studentList=repo.findByName("bolu");
		List<Student> studentList2=repo.findAll();

		for (var student:studentList

		     ) {

			System.err.println(student.getLastname());

		}





	}

	// Test native anmed query
	@Test
	public void testNativeNamedQuery(){

		int countCustomByName=repo.findNameNative("ankara");


		System.err.println("/////////////////");
		System.err.println(countCustomByName);
		System.err.println("////////////////");

assertThat(countCustomByName).isGreaterThan(0);


	}



	@Test
	public void testupdateStudemts(){
		int test=repo.updateNameById("ankara",5);
		assertThat(test).isGreaterThan(0);

	}

}
