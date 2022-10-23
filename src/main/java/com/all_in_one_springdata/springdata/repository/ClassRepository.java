package com.all_in_one_springdata.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.all_in_one_springdata.springdata.entity.onetomany.Class;
public interface ClassRepository extends JpaRepository<Class,Integer> {


}
