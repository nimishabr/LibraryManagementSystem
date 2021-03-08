package com.lms.model;

import javax.persistence.*;

@Entity
@Table
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "library_id_generator")
    @Column(name = "borrowedBookId",updatable = false, nullable = false)
    private Integer BorrowedBookId;
    @Column(name = "author")
    private String author;

    @Column(name = "BorrowedBookName")
    private String BorrowedBookName;

    public Integer getBorrowedBookId() {
        return BorrowedBookId;
    }

    public void setBorrowedBookId(Integer borrowedBookId) {
        BorrowedBookId = borrowedBookId;
    }

    public String getBorrowedBookName() {
        return BorrowedBookName;
    }

    public void setBorrowedBookName(String borrowedBookName) {
        BorrowedBookName = borrowedBookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
