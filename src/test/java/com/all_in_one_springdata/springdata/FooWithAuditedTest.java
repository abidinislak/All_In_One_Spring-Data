package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.otherStuff.FooWithAudit;
import com.all_in_one_springdata.springdata.repository.FooWithAuditRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FooWithAuditedTest {


    @Autowired
    FooWithAuditRepository repo;

    @Test
    public void saveFooWithTest() {

        FooWithAudit temp = new FooWithAudit();


        temp.setFooName("first entity");

        repo.save(temp);

        assertTrue(temp.getId() > 0);


    }
}
