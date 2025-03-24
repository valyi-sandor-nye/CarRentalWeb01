package hu.valyis.progenv.carrentalweb01.service;

import hu.valyis.progenv.carrentalweb01.model.Book;
import hu.valyis.progenv.carrentalweb01.model.Author;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = List.of(
            Book.
                    builder()
                    .title("A kőszívű ember fiai")
                    .publicationDate(LocalDate.of(1852, 1, 1))
                    .author(Author
                                    .builder()
                            .name("Jókai Mór")
                                    .dateOfBirth(LocalDate.of(1828,12,1))
                                    .build()
                            )
                    .build(),
            Book.builder()
                    .title("A rab ember fiai")
                    .publicationDate(LocalDate.of(1920,1,1))
                    .author(Author.builder()
                            .name("Móra Ferenc")
                            .dateOfBirth(LocalDate.of(1900,1,1))
                            .build()
                    )
                    .build(),
            Book.builder()
                    .title("A szabad ember fiai")
                    .publicationDate(LocalDate.of(2020,1,1))
                    .author(Author.builder()
                            .name("Rab Antal")
                            .dateOfBirth(LocalDate.of(2000,1,1))
                            .build()
                    )
                    .build()


    );

    public List<Book> getAllBooks() {
        return books;
    }
}
