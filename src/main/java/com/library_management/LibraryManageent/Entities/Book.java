package com.library_management.LibraryManageent.Entities;

import com.library_management.LibraryManageent.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;
    @Column(unique = true)
    private String title;
    private Integer total_pages;
    private  Boolean isissued;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private Integer price;
    @JoinColumn
    @ManyToOne
    private Author author;//foreign key should only be added in child class
}
