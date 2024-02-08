package hh.sof3.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, author;
    private int publicationYear;
    private String isbn;
    private Double price;

    //Constructor

    public Book(String title, String author, int publicationYear, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    //Null Constructor

    public Book() {
        super();
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0.0;
    }

    //Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //Getter

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    //ToString

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", prive=" + price + "]";
    }
}
