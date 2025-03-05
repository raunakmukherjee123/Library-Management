package com.library_management.LibraryManageent.Entities;

import com.library_management.LibraryManageent.Enums.Transaction_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transaction_id;
    @Enumerated(value = EnumType.STRING)
    private Transaction_Status transaction_status;
    @CreatedDate//mark the issuedate
    private Date issuedate;
    private Date returndate;
    private Integer fine;
    @JoinColumn
    @ManyToOne
    private Book book;
    @JoinColumn
    @ManyToOne
    private  LibraryCard libraryCard;
}
