package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Entities.Book;
import com.library_management.LibraryManageent.Entities.LibraryCard;
import com.library_management.LibraryManageent.Entities.Transaction;
import com.library_management.LibraryManageent.Enums.Transaction_Status;
import com.library_management.LibraryManageent.Repository.BookRepository;
import com.library_management.LibraryManageent.Repository.CardRepository;
import com.library_management.LibraryManageent.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService
{
    public static Integer max=3;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(Integer cardid,Integer bookid) throws Exception
    {
        Optional<Book> bookOptional=bookRepository.findById(bookid);
        if(bookOptional.isEmpty())
        {
            throw  new Exception("BookId entered is incorrect");
        }
        Book book=bookOptional.get();
     //   Book book=bookRepository.findById(bookid).get();
        Optional<LibraryCard> libraryCardOptional=cardRepository.findById(cardid);
        if (libraryCardOptional.isEmpty())
        {
            throw new Exception("CardId entered is wrong");
        }
        LibraryCard libraryCard=libraryCardOptional.get();
        //LibraryCard libraryCard=cardRepository.findById(cardid).get();
        Transaction transaction=new Transaction();
        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);
        transaction.setTransaction_status(Transaction_Status.PENDING);
        if(book.getIsissued()==true)
        {
            transaction.setTransaction_status(Transaction_Status.FAILURE);
            transactionRepository.save(transaction);
            return "Book already issued to cardId "+libraryCard.getCard_no();
        }
        if(libraryCard.getTotal_books_issued()>max)
        {
            transaction.setTransaction_status(Transaction_Status.FAILURE);
            transactionRepository.save(transaction);
            return "Reached maximum limit";
        }


        //happy flow
        transaction.setTransaction_status(Transaction_Status.SUCCESS);
        book.setIsissued(true);
        libraryCard.setTotal_books_issued(libraryCard.getTotal_books_issued()+1);
        cardRepository.save(libraryCard);
        bookRepository.save(book);
        transaction=transactionRepository.save(transaction);
        return  "Transaction has been completed with transaction_id "+transaction.getTransaction_id();
    }
}
