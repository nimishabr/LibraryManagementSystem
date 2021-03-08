package com.lms.service.impl;

import com.lms.dto.BorrowedBookDto;
import com.lms.dto.LibraryBookDto;
import com.lms.model.LibraryBook;
import com.lms.repository.LibraryBookRepository;
import com.lms.service.LibraryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryBookServiceImpl implements LibraryBookService {
    @Autowired
    private LibraryBookRepository bookRepository;

    @Override
    public List<LibraryBook> getAllBooks() throws Exception {
        {
            List<LibraryBook> library = null;

            List<LibraryBook> books = bookRepository.findAll();
            if (!books.isEmpty()) {
                return books;
            }
            return null;
        }
    }
}
