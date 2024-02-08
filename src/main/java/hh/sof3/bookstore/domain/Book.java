package hh.sof3.bookstore.domain;

public class Book {

    //Attributes

    private String title;
    private String author;
    private int publicationYear;
    private int isbn;
    private int prive;

    //Constructor

    public Book(String title, String author, int publicationYear, int isbn, int prive) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.prive = prive;
    }

    //Null Constructor

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = 0;
        this.prive = 0;
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

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setPrive(int prive) {
        this.prive = prive;
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

    public int getIsbn() {
        return isbn;
    }

    public int getPrive() {
        return prive;
    }

    //ToString

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", prive=" + prive + "]";
    }
}
