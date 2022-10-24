package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.entityHiyeracy.EmployeTablePerClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryTablePerClass extends JpaRepository<EmployeTablePerClass, Integer> {


}
