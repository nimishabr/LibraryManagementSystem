package com.lms.model;

import javax.persistence.*;

@Entity
@Table
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "library_id_generator")
    @Column(name = "borrowedBookId",updatable = false, nullable = false)
    private Integer borrowedBookId;
    @Column(name = "author")
    private String author;

    @Column(name = "borrowedBookName")
    private String borrowedBookName;

    public Integer getBorrowedBookId() {
        return borrowedBookId;
    }

    public void setBorrowedBookId(Integer borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }

    public String getBorrowedBookName() {
        return borrowedBookName;
    }

    public void setBorrowedBookName(String borrowedBookName) {
        this.borrowedBookName = borrowedBookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
