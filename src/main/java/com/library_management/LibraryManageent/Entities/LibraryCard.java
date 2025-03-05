package com.library_management.LibraryManageent.Entities;

import com.library_management.LibraryManageent.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_no;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardstatus;
    private  int total_books_issued;
    private Date validity;
    @JoinColumn 
    @OneToOne
    private Student student;
}
