package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.onetomany.Class;
import com.all_in_one_springdata.springdata.entity.onetomany.Person;
import com.all_in_one_springdata.springdata.repository.ClassRepository;
import com.all_in_one_springdata.springdata.repository.PersonRepository;
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
public class PersonRepositoryTest {


	@Autowired
	PersonRepository repo;


	@Autowired
	TestEntityManager entityManager;

	@Autowired
	ClassRepository repoClass;

	@Test
	public void testSavePerson(){

		Person savePerson=new Person();

		savePerson.setName("abidin");
		savePerson.setLastName("last name abidin");

var savedPerson=repo.save(savePerson);




	}


	@Test
	public void testSAveWithClass(){

		Person savePerson=new Person();

		savePerson.setName("ccc");


Class varCass=entityManager.find(Class.class,3);


		savePerson.setOwnClass(varCass);


		var savedPerson=repo.save(savePerson);
		assertThat(savedPerson.getId()).isGreaterThan(0);


	}

	@Test
	public void testListWithRelatedEntity(){

		List<Person>  persons=repo.findAll();


		for (Person person:persons
		     ) {

			System.out.println(person.getOwnClass());

		}


	}


}
