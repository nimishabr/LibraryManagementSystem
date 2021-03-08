package com.lms.service;

import com.lms.dto.BorrowedBookDto;
import com.lms.dto.LibraryBookDto;
import com.lms.model.BorrowedBook;
import com.lms.model.LibraryBook;

import java.util.List;

public interface LibraryBookService {

   List<LibraryBook> getAllBooks() throws Exception;
}
