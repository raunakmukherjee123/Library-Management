package com.library_management.LibraryManageent.Repository;

import com.library_management.LibraryManageent.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
