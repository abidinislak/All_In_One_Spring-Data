package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.entityHiyeracy.EmployeSingleTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeSingleTable, Integer> {
}
