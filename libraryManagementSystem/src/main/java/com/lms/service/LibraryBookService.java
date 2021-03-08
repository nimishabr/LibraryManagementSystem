package com.lms.service;
import com.lms.model.LibraryBook;

import java.util.List;

public interface LibraryBookService {

   List<LibraryBook> getAllBooks() throws Exception;
}
