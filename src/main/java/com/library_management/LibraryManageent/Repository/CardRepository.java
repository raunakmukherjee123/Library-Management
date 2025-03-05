package com.library_management.LibraryManageent.Repository;

import com.library_management.LibraryManageent.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer>
{

}
