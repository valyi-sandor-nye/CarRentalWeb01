package hu.valyis.progenv.carrentalweb01.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Author {
    private String name;
    private LocalDate dateOfBirth;
}
