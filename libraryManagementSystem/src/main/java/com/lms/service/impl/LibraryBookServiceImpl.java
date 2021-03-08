package com.lms.service.impl;
import com.lms.model.LibraryBook;
import com.lms.repository.LibraryBookRepository;
import com.lms.service.LibraryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBookServiceImpl implements LibraryBookService {
    @Autowired
    private LibraryBookRepository bookRepository;

    @Override
    public List<LibraryBook> getAllBooks() throws Exception {
        {
            List<LibraryBook> books = bookRepository.findAll();
            if (!books.isEmpty()) {
                return books;
            }
            return books;
        }
    }
}
