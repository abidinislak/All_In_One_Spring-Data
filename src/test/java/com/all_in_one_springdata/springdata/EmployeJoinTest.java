package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.entityHiyeracy.PartTimeEmployeJoin;
import com.all_in_one_springdata.springdata.repository.EmployeeRepositoryJoin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeJoinTest {


    @Autowired
    EmployeeRepositoryJoin repo;

    @Test
    public void testSave() {


        repo.save(new PartTimeEmployeJoin("Heyt bee, tamam bu iş olum", new BigDecimal(123)));


        System.err.println(".......");


    }
}
