package com.lms.dto;

public class BorrowedBookDto {
    private Integer borrowedBookId;
    private String borrowedBookName;
    private String author;

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
