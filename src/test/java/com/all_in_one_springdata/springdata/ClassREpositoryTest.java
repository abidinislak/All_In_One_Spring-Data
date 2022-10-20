package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.onetomany.Class;
import com.all_in_one_springdata.springdata.repository.ClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ClassREpositoryTest {


	@Autowired
	ClassRepository repo;


	@Test
	public void testsaveClass(){

		Class saveClass=new Class("saved class");

	var dgec=	repo.save(saveClass);


	assertThat(dgec.getId()).isGreaterThan(0);

	}


	@Test
	public void testClassRelatedEntity(){

		List<Class> list=repo.findAll();

		for (var dgec:list
		     ) {

			System.out.println("......."+dgec.getName());


			for (var dgec2:dgec.getPersons()
			     ) {

				System.out.println(dgec2.getName()+"///////////////////////");

			}
		}


	}
}
