package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Entities.Student;
import com.library_management.LibraryManageent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;//object of jparepository class, not of studentrepository interface beacuse it is
    //impossible to create object of interface class
    public String addStudent(Student student)
    {
        studentRepository.save(student);
        return "Student saved successfully";
    }
}


