package com.all_in_one_springdata.springdata;

import com.all_in_one_springdata.springdata.entity.onetoone.BookDetail;
import com.all_in_one_springdata.springdata.entity.onetoone.Book;
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
	public void testBookSave(){

		Book saveBook=new Book();


		saveBook.setName("test güncelleme");


		BookDetail varDBookDetail=new BookDetail();
		varDBookDetail.setName("test etail güncellem");

		saveBook.setBookDetail(varDBookDetail);

		repo.save(saveBook);


		assertThat(saveBook.getId()).isGreaterThan(0);




	}
}
