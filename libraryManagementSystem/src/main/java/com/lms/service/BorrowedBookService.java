package com.lms.service;

import com.lms.dto.BorrowedBookDto;
import com.lms.model.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {
    BorrowedBook borrowBook(BorrowedBookDto borrowedBookDto);
    BorrowedBook copyBook(Integer bookId);
    void deleteBookById(List<Integer> bookIds);
}
