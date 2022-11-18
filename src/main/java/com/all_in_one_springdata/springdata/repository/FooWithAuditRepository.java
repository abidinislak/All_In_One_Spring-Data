package com.all_in_one_springdata.springdata.repository;

import com.all_in_one_springdata.springdata.entity.otherStuff.FooWithAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FooWithAuditRepository extends JpaRepository<FooWithAudit, Integer> {
}
