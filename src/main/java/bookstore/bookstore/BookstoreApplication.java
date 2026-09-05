package bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Demodataa kantaan
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book eka = new Book("Kirjan nimi", "Irja Kirjailija", "4212342-1", 2010, 0);
			bookRepository.save(eka);
			Book toka = new Book("Toinen", "Kirjailija 2", "1231232-22", 2018, 0);
			bookRepository.save(toka);
			Book kolmas = new Book("Third edition", "Aaa Beeeee", "2342132-4", 2016, 0);
			bookRepository.save(kolmas);
		};
	}

}
