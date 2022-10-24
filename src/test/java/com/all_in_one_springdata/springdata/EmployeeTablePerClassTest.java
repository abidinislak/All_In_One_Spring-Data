package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.entityHiyeracy.FullTimeEmployeTablePerClass;
import com.all_in_one_springdata.springdata.repository.EmployeeRepositoryTablePerClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeeTablePerClassTest {


    @Autowired
    EmployeeRepositoryTablePerClass repo;


    @Test
    public void testSave() {


        repo.save(new FullTimeEmployeTablePerClass("asdfasd", 123123));


    }
}
