package com.library_management.LibraryManageent.Repository;

import com.library_management.LibraryManageent.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
