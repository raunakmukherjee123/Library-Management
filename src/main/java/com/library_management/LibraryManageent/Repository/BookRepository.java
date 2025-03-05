package com.library_management.LibraryManageent.Repository;

import com.library_management.LibraryManageent.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
