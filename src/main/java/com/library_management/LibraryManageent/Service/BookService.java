package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Entities.Author;
import com.library_management.LibraryManageent.Entities.Book;
import com.library_management.LibraryManageent.Exceptions.InvalidPageCountException;
import com.library_management.LibraryManageent.Repository.AuthorRepository;
import com.library_management.LibraryManageent.Repository.BookRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
  public String addBook(Book book) throws Exception
  {
      if(book.getTotal_pages()<=0)
      {
          throw new InvalidPageCountException("Page count is incorrect");
      }
      bookRepository.save(book);
      return "Book details have been added";
  }
  public  String associate(Integer bookid, Integer authorid) throws Exception
  {
     
      Optional<Book> bookOptional=bookRepository.findById(bookid);
      if(bookOptional.isEmpty())
      {
          //throw exception message
          throw new Exception("Bookid not found");
      }
      Book book=bookOptional.get();
      Optional<Author> authorOptional=authorRepository.findById(authorid);
      if(authorOptional.isEmpty())
      {
          throw new Exception("Authorid not found");
      }
      Author author=authorOptional.get();
      book.setAuthor(author);
      author.setTotal_books(author.getTotal_books()+1);
       bookRepository.save(book);
       authorRepository.save(author);
       return "Book and author have been associated";
  }
    public List<Book> getBooks(Integer authorid)
    {
        List<Book> list=bookRepository.findAll();
        List<Book> ans=new ArrayList<>();
        for(Book book:list)
        {
            if(book.getAuthor().getAuthorid().equals(authorid))//book entity internally have author entity
            {
                ans.add(book);
            }
        }
        return ans;
    }
}
