package com.library_management.LibraryManageent.Controller;

import com.library_management.LibraryManageent.Entities.Book;
import com.library_management.LibraryManageent.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController
{
    @Autowired
    private BookService bookService;
    @PostMapping("add_Book")
    public ResponseEntity addBook(@RequestBody Book book) {
        try {
            String res = bookService.addBook(book);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("associateBook&Author")
    public  String associateBook_Author(@RequestParam("bookid")Integer bookid,
                                        @RequestParam("authorid")Integer authorid) {
        try {
            String res = bookService.associate(bookid, authorid);
            return res;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("get_books_by_author")
    public List<Book> getBooks(@RequestParam("authorid")Integer authorid)
    {
        List<Book> ans=bookService.getBooks(authorid);
        return ans;
    }
}
