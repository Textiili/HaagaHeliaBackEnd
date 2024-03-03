package hh.sof3.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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

    @ManyToOne //Vaiha ManyToMany?
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid")
    private Category category;

    //Konstruktorit:
    public Book() {}

    public Book(String title, String author, int publicationYear, String isbn, float price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
	public String toString() {
        if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + 
        ", year=" + publicationYear + ", isbn=" + isbn + ", price=" + price + 
        ", category=" + this.getCategory() + "]";
        else 
        return "Book [id=" + id + ", title=" + title + ", author=" + author + 
        ", year=" + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
	}
}
