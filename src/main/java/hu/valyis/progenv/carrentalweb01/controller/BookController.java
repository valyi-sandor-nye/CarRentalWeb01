package hu.valyis.progenv.carrentalweb01.controller;

import hu.valyis.progenv.carrentalweb01.domain.Book;
import hu.valyis.progenv.carrentalweb01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
