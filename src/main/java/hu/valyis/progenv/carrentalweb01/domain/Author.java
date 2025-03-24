package hu.valyis.progenv.carrentalweb01.domain;

import java.time.LocalDate;

public class Author {
    private String name;
    private LocalDate dateOfBirth;

    // Private constructor to enforce the use of the builder
    private Author(Builder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
    }

    // Static builder() method
    public static Builder builder() {
        return new Builder();
    }


    // Static nested Builder class
    public static class Builder {
        private String name;
        private LocalDate dateOfBirth;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    // Optionally, you can override toString() for easier debugging
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}