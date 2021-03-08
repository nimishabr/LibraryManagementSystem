package com.lms.model;
import javax.persistence.*;


@Entity
@Table
public class LibraryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "library_id_generator")
    @Column(name = "bookId",updatable = false, nullable = false)
    private Integer bookId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "author")
    private String author;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
