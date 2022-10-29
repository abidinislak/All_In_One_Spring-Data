package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.otherStuff.Stuff;
import com.all_in_one_springdata.springdata.repository.StuffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StuffRepositoryTest {


    @Autowired
    StuffRepository repo;


    @Test
    public void saveTest() {

        Stuff saveTemp = new Stuff();

        saveTemp.setName("saaaa");
        saveTemp.setCategory("bbbb");


        repo.save(saveTemp);

        System.err.println(saveTemp.getId());
        assertThat(saveTemp.getId()).isGreaterThan(0);

    }

    //    Checking updated isworking
    @Test
    public void tesUpdatedisworking() {

        var upated = repo.findById(30).get();

        upated.setName("updated");

        repo.save(upated);

        assertThat(upated.getUpdatedDate()).isNotNull();


    }

    //    SOFT DELEET CHECK.....Heyt Yawrumbe... yürü jpa....
//    Check new entity
    @Test
    public void testSoftDelete() {

        Stuff vartemp = new Stuff();

        vartemp.setName("check soft delete");
        vartemp.setCategory("sof delete");

        repo.save(vartemp);

        var temp2 = repo.findById(vartemp.getId());

        repo.deleteById(temp2.get().getId());


    }


//    check sorf delete update


    @Test
    public void testSoftDeleteUpdate() {

        var updateSoft = repo.findById(34).get();

        repo.deleteById(updateSoft.getId());

//        System.err.println(updateSoft.isDeleted());

        assertThat(updateSoft.isDeleted()).isTrue();
    }

    //    check sorf delete is working with where condiitons
    @Test
    public void testSorfWithWhere() {

        List<Stuff> tempList = repo.findAll();

        assertThat(tempList.size()).isLessThan(7);


    }


}
