package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.entityHiyeracy.PartTimeEmployeSingleTable;
import com.all_in_one_springdata.springdata.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeSingleTableRepoTest {


    @Autowired
    EmployeeRepository repo;

    @Test
    public void testSave() {


        repo.save(new PartTimeEmployeSingleTable("asdas", new BigDecimal(123)));


        System.err.println(".......");


    }
}
