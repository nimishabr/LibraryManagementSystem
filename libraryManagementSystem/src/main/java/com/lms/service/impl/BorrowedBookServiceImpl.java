package com.lms.service.impl;

import com.lms.dto.BorrowedBookDto;
import com.lms.model.BorrowedBook;
import com.lms.model.LibraryBook;
import com.lms.repository.BorrowedBookRepository;
import com.lms.repository.LibraryBookRepository;
import com.lms.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {

    @Autowired
    @Qualifier("borrowedBookRepository")
    BorrowedBookRepository borrowedBookRepository;
    @Autowired
    @Qualifier("libraryBookRepository")
    LibraryBookRepository libraryBookRepository;

    @Override
    public BorrowedBook borrowBook(BorrowedBookDto borrowedBookDto) {
        Optional<LibraryBook> borrowedBook = libraryBookRepository.findById(borrowedBookDto.getBorrowedBookId());
        BorrowedBook borrowedBookToSave =new BorrowedBook();
        if (borrowedBook.isPresent()) {
            borrowedBookToSave.setBorrowedBookId(borrowedBook.get().getBookId());
            borrowedBookToSave.setBorrowedBookName(borrowedBook.get().getBookName());
            borrowedBookToSave.setAuthor(borrowedBook.get().getAuthor());
            borrowedBookRepository.save(borrowedBookToSave);
            libraryBookRepository.deleteById(borrowedBookDto.getBorrowedBookId());
        }else {
            System.out.println("No such book exists in library");
        }
        return null;
    }

    @Override
    public BorrowedBook copyBook(Integer bookId) {
       Optional< LibraryBook>  libraryBook = libraryBookRepository.findById(bookId);
       BorrowedBook  borrowedBook = new BorrowedBook();
       if(libraryBook.isPresent()){
           borrowedBook.setBorrowedBookId(libraryBook.get().getBookId());
           borrowedBook.setBorrowedBookName(libraryBook.get().getBookName() );
           borrowedBook.setAuthor(libraryBook.get().getAuthor());
           borrowedBookRepository.save(borrowedBook);
       }
       libraryBookRepository.deleteById(bookId);
        return borrowedBook;
    }

    @Override
    public void deleteBookById(List<Integer> bookIds) {
        LibraryBook libraryBookToSave =null;
        BorrowedBook borrowedBook = null;

        for (int i=0;i<bookIds.size();i++){
            Optional<BorrowedBook> book = borrowedBookRepository.findById(bookIds.get(i));
            if(book.isPresent()) {
                borrowedBookRepository.deleteById(book.get().getBorrowedBookId());
                libraryBookToSave.setBookId(book.get().getBorrowedBookId());
                libraryBookToSave.setBookName(book.get().getBorrowedBookName());
                libraryBookToSave.setAuthor(book.get().getAuthor());
                libraryBookRepository.save(libraryBookToSave);

            }else {
                System.out.println("No book found");
            }
            }
        }
    }

