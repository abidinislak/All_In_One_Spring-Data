package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.entityHiyeracy.EmployeJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJoin extends JpaRepository<EmployeJoin, Integer> {
}
