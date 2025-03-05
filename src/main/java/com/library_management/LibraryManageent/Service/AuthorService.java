package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Entities.Author;
import com.library_management.LibraryManageent.Entities.Book;
import com.library_management.LibraryManageent.Repository.AuthorRepository;
import com.library_management.LibraryManageent.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
   public String addAuthor(Author author)
   {
       author.setTotal_books(0);
       authorRepository.save(author);
       return "Author details saved";
   }

}
