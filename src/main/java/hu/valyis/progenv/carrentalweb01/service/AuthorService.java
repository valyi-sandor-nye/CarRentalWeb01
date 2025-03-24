package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.domain.Author;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorService {
    private List<Author> authors = List.of(
                    Author
                            .builder()
                            .name("Jókai Mór")
                            .dateOfBirth(LocalDate.of(1828,12,1))
                            .build()
                    ,
                    Author
                            .builder()
                            .name("Móra Ferenc")
                            .dateOfBirth(LocalDate.of(1900,1,1))
                            .build()
                    ,
                    Author
                            .builder()
                            .name("Rab Antal")
                            .dateOfBirth(LocalDate.of(2000,1,1))
                            .build()
                    );

    public List<Author> getAllAuthors() {
        return authors;
    }
}
