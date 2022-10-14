package com.all_in_one_springdata.springdata;


import com.all_in_one_springdata.springdata.entity.Book;
import com.all_in_one_springdata.springdata.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class BookRepositoryTest {

@Autowired
    BookRepository repo;

    @Test

    public void testBookSAve(){

       Book savebook=new Book("java");

       repo.save(savebook);

       assertThat(savebook.getId()).isGreaterThan(0);



    }
}
