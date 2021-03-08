package com.lms.conroller;

import com.lms.dto.BorrowedBookDto;
import com.lms.dto.LibraryBookDto;
import com.lms.model.BorrowedBook;
import com.lms.model.LibraryBook;
import com.lms.service.BorrowedBookService;
import com.lms.service.LibraryBookService;
import com.lms.utilities.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lms/demo/book")
public class BookController {
    @Autowired
    LibraryBookService libraryBookService;
    @Autowired
    BorrowedBookService borrowedBookService;

    @GetMapping(value = "/getBooks")
    public ResponseEntity<?> getAllBooks(@RequestBody Integer bookId) {
        List<LibraryBook> libraryBook =new ArrayList<LibraryBook>();
        try {
            libraryBook = libraryBookService.getAllBooks();
            return new ResponseEntity<>(libraryBook, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(404, "Related not found in LMS"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/borrowBook")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowedBookDto borrowedBookDto) {
        ErrorResponse errorResponse = null;
        try {
            BorrowedBook borrowedBook = borrowedBookService.borrowBook(borrowedBookDto);
            return new ResponseEntity<>(borrowedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(  new ErrorResponse(500, "internal server error, please contact admin"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(value = "/copyBook/{bookId}")
    public ResponseEntity<?> copyBook(@PathVariable Integer bookId ) {
        ErrorResponse errorResponse = null;
        try {
            BorrowedBook borrowedBook = borrowedBookService.copyBook(bookId);
            return new ResponseEntity<>(borrowedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(  new ErrorResponse(500, "internal server error, please contact admin"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(value = "/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody List<Integer> bookIds) {
        try {
            borrowedBookService.deleteBookById(bookIds);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(417, "Cannot delete book"), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
