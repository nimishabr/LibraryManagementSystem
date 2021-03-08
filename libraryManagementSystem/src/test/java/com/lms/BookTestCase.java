package com.lms;

import com.lms.dto.BorrowedBookDto;
import com.lms.dto.LibraryBookDto;
import com.lms.model.BorrowedBook;
import com.lms.model.LibraryBook;
import com.lms.service.BorrowedBookService;
import com.lms.service.LibraryBookService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class BookTestCase {
    @Autowired
    LibraryBookService libraryBookServiceImpl;
    @Autowired
    BorrowedBookService borrowedBookServiceImpl;
    /*
     * This test method is To get and view books in library
     */
    @Test(expected = Exception.class)
    @Ignore
    public void getAllBooks() throws Exception {
        List<LibraryBook> libraryBooks = new ArrayList<>();
        LibraryBook bookToAdd = new LibraryBook();
        bookToAdd.setBookId(1000);
        bookToAdd.setBookName("first");
        bookToAdd.setAuthor("author_1");
        libraryBooks.add(bookToAdd);
        bookToAdd =new LibraryBook();
        bookToAdd.setBookId(2000);
        bookToAdd.setBookName("second");
        bookToAdd.setAuthor("author_2");
        libraryBooks.add(bookToAdd);
        try {
            libraryBooks= libraryBookServiceImpl.getAllBooks();
        } catch (Exception e) {
            Assert.fail("fetching failed !!!");
        }
        System.out.println(libraryBooks);
    }

    /*
     * This test method is To borrow a book from library
     */
    @Test
    @Ignore
    public void borrowBook() throws Exception {
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto();
        borrowedBookDto.setBorrowedBookId(1000);
        borrowedBookDto.setBorrowedBookName("Test");
        borrowedBookDto.setAuthor("author_test");
        try {
            borrowedBookServiceImpl.borrowBook(borrowedBookDto);
        } catch (Exception e) {
            Assert.fail("borrowing failed !!!");
        }

    }

    /**
     * This method is to copy book from library
     * @throws Exception
     */
    @Test
    @Ignore
    public void copyBook()  throws Exception {
        try{
            borrowedBookServiceImpl.copyBook(1000);
        }catch (Exception e){
            Assert.fail("copy failed !!!");
        }
    }
    /*
     * This test method is To return book to library from borrowed list
     */
    @Test
    @Ignore
    public void deleteBooksById() throws Exception {
        try {
            List<Integer> bookIds = new ArrayList<>();
            bookIds.add(1000);
            bookIds.add(2000);
            borrowedBookServiceImpl.deleteBookById(bookIds);
        } catch (Exception e) {
            Assert.fail("deletion failed !!!");
        }
    }

}
