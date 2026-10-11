package bookstore.bookstore;

import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	private final CategoryRepository categoryRepository;

    BookstoreApplication(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Demodataa kantaan
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, UserRepository userRepository) {
		return (args) -> {
			Category cat1 = new Category("Thriller");
			categoryRepository.save(cat1);
			Category cat2 = new Category("Action");
			categoryRepository.save(cat2);

			Book eka = new Book("Kirjan nimi", "Irja Kirjailija", "4212342-1", 2010, 0, cat1);
			bookRepository.save(eka);
			Book toka = new Book("Toinen", "Kirjailija 2", "1231232-22", 2018, 0, cat2);
			bookRepository.save(toka);
			Book kolmas = new Book("Third edition", "Aaa Beeeee", "2342132-4", 2016, 0, cat2);
			bookRepository.save(kolmas);

			User user1 = new User("user", "$2a$10$hY8ACEcvaiD60Kw7vNkAj.FUdTTKop3JOSGnB2wnyv0S8w7/VOywq", "USER");
			userRepository.save(user1);
			User user2 = new User("admin", "$2a$10$vXcmipLRQOnqGBhMduH0FehCLS4e0K9E1IfdNIjr4Sg.9Xr5DCDKW", "ADMIN");
			userRepository.save(user2);


		};
	}

}
