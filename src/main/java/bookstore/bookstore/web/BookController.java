package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class BookController {
    
    //repository injection
    private final BookRepository repository;
    public BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }
    
    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("/save")
    public String postNewBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook() {
        return "editbook";
    }
    
    
}
