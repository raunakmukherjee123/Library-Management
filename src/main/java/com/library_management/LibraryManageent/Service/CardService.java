package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Enums.CardStatus;
import com.library_management.LibraryManageent.Entities.LibraryCard;
import com.library_management.LibraryManageent.Entities.Student;
import com.library_management.LibraryManageent.Repository.CardRepository;
import com.library_management.LibraryManageent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    StudentRepository studentRepository;
    public String generatecard()
    {
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardstatus(CardStatus.NEW);
        libraryCard.setTotal_books_issued(0);
        Date expirydate=new Date(2028,6,1);
        libraryCard.setValidity(expirydate);
        libraryCard=cardRepository.save(libraryCard);
        return "card had been created with card number "+libraryCard.getCard_no();
    }
    public String associate(Integer cardid,Integer studentid)
    {
      LibraryCard libraryCard=cardRepository.findById(cardid).get();
        Student student=studentRepository.findById(studentid).get();
        libraryCard.setCardstatus(CardStatus.ISSUED);
        libraryCard.setStudent(student);
        // with entities, we have to set as per entity
        cardRepository.save(libraryCard);
        return "The card and the student have been associated";
    }
}


