package com.library_management.LibraryManageent.Controller;

import com.library_management.LibraryManageent.Entities.Author;
import com.library_management.LibraryManageent.Entities.Book;
import com.library_management.LibraryManageent.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;
    @PostMapping("add_author")
    public String add_Author(@RequestBody Author author)
    {
        String res=authorService.addAuthor(author);
        return res;
    }

}
