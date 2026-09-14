package bookstore.bookstore.web;

import bookstore.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class BookController {
    
    private final CategoryRepository categoryRepository;
    //repository injection
    private final BookRepository repository;
    public BookController(BookRepository repository, CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
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
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }
    
    @PostMapping("/save")
    public String postNewBook(@Valid @ModelAttribute("editBook") Book book, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("editBook", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "editbook";
        }

        repository.save(book);  //pelkkä tää ja Book book ilman validointia
        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("editBook", repository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }
    
    
}
