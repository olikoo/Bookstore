package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.bookstore.web.BookController;
import bookstore.bookstore.web.RestBookController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private final BookController controller;

	@Autowired 
	private final RestBookController rbcontroller;

	@Autowired 
	public BookstoreApplicationTests(BookController controller, RestBookController rbcontroller){
		this.controller = controller;
		this.rbcontroller =  rbcontroller;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void controllerLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(rbcontroller).isNotNull();
	}
}
