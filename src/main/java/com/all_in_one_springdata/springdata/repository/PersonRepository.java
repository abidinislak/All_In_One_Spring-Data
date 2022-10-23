package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.onetomany.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository   extends JpaRepository<Person,Integer> {



}
