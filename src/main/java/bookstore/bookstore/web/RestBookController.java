package bookstore.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
public class RestBookController {
    private final BookRepository bookRepository;

    //constructor injection
    public RestBookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long bookId){
        return bookRepository.findById(bookId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("books/{id}")
    public Book saveEditedBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }
    
}
