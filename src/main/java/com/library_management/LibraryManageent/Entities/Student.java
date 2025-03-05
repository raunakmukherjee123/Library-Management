package com.library_management.LibraryManageent.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity//this annotation tells us that this class is the schema of database server
@Table
@Getter//develop all getter()
@Setter//develop all setter()
@NoArgsConstructor//default constructor
@AllArgsConstructor//parameterized constructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false)
    private  String name;
    private Integer age;
    private String branch;
    private double cgpa;
    @Column(unique = true,nullable = false)
     private String emailid;
}
//@getter,setter,NoArgsConstructor,AllArgsConstructor are internally created by lombok dependency. No need to create
//getter(), setter(), constructor() manually
//@Entity need default constructor mandatorily to work
//by default, default constructor is always present in class, but
//if we create parameterized constructor, default constructor is gone. So we manually create default constructor.
//to change the name of table:      @Table(name="xyz")