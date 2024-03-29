package hh.sof3.bookstore.domain;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JsonIgnoreProperties ("books")
    @JoinColumn(name = "categoryId") // FK
    private Category category;

    //Constructor

    public Book(String title, String author, int publicationYear, String isbn, Double price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    //Null Constructor

    public Book() {
        super();
        this.id = null;
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0.0;
        this.category = null;
    }

    //Setter

    public void setId(Long id){
        this.id = id;
    }

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

    public void setCategory(Category category) {
        this.category = category;
    }

    //Getter

    public Long getId(){
        return id;
    }

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

    public Category getCategory() {
        return category;
    }

    //ToString

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
            + ", prive=" + price + ", category= " + this.getCategory() + "]";
        else
            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", prive=" + price + "]";
    }
}
