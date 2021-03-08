package com.lms.dto;

public class BorrowedBookDto {
    private Integer BorrowedBookId;
    private String BorrowedBookName;
    private String author;

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
