package hu.valyis.progenv.carrentalweb01.model;

import java.time.LocalDate;
public class Book {
    private Long id;
    private String title;
    private LocalDate publicationDate;
    private Author author;

    // Private constructor
    private Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.publicationDate = builder.publicationDate;
        this.author = builder.author;
    }
    // Static builder() method
    public static Builder builder() {
        return new Builder();
    }



    // Static nested Builder class
    public static class Builder {
        private Long id;
        private String title;
        private LocalDate publicationDate;
        private Author author;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder publicationDate(LocalDate publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

        public Builder author(Author author) {
            this.author = author;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    // Optional for debugging
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", author=" + author +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}