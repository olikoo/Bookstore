package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;
import jakarta.activation.DataSource;


@DataJpaTest 
public class BookstoreRepositoryTests {

    @Autowired 
    private BookRepository repository;

    @Autowired 
    private CategoryRepository crepository;

    @Autowired 
    private UserRepository urepository;

    //check which db is used
    @Autowired 
    DataSource dataSource;

    @Test 
    public void defaultUserFound(){
        User user = urepository.findByUsername("user");
        assertThat(user).isNotNull();
    }

    @Test 
    public void addAndFindBook(){
        Book book = new Book("xxx", "yyy", "zzz", 2011, 0);
        repository.save(book);

        assertThat(repository.findById(book.getId()).get().getAuthor().equals("yyy"));
    }


}
