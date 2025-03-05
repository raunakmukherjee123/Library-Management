package com.library_management.LibraryManageent.Service;

import com.library_management.LibraryManageent.Entities.Student;
import com.library_management.LibraryManageent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student)
    {
        studentRepository.save(student);
        return "Student saved successfully";
    }
}


