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
        libraryCard=cardRepository.save(libraryCard);//saving libraryCard object into database after creating details
        return "card had been created with card number "+libraryCard.getCard_no();
    }
    public String associate(Integer cardid,Integer studentid)
    {
      LibraryCard libraryCard=cardRepository.findById(cardid).get();//finding object based on cardid
        Student student=studentRepository.findById(studentid).get();
        libraryCard.setCardstatus(CardStatus.ISSUED);
        libraryCard.setStudent(student);//indirectly setting foreign key in library card table but because we are playing
        // with entities, we have to set as per entity
        cardRepository.save(libraryCard);
        return "The card and the student have been associated";
    }
}

//Object of entity class will always go to database--> (IMPORTANT RULE)
