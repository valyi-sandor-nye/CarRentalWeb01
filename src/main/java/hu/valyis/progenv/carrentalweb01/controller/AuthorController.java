package hu.valyis.progenv.carrentalweb01.controller;

import hu.valyis.progenv.carrentalweb01.model.Author;
import hu.valyis.progenv.carrentalweb01.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService AuthorService;

    @GetMapping()
    public List<Author> getAllAuthors() {
        return AuthorService.getAllAuthors();
    }
}
