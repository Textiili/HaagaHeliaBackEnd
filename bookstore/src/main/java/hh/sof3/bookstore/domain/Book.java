package hh.sof3.bookstore.domain;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Float price;

    //Konstruktorit:
    public Book() {//Tyhjä olio
        super();
        this.id = null;
        this.title = null;
        this.author = null;
        this.publicationYear = null;
        this.isbn = null;
        this.price = null;
    }
    //Ilman id:tä:
    public Book(String title, String author, int publicationYear, String isbn, float price) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    //Id:llä:
    public Book(Long id, String title, String author, int publicationYear, String isbn, float price) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    
    //Getterit ja setterit:
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

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + 
        ", year=" + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
	}
}
