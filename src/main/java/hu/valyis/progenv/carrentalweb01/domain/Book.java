package hu.valyis.progenv.carrentalweb01.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
//@Entity
public class Book {
    //@Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String title;
    //@Column(name = "publication:date")
    private LocalDate publicationDate;
    private Author author;

}
