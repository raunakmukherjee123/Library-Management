package com.library_management.LibraryManageent.Controller;

import com.library_management.LibraryManageent.Entities.Student;
import com.library_management.LibraryManageent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/")
public class StudentController
{
 @Autowired
 private StudentService studentService;
 @PostMapping("add")
  public String addStudent(@RequestBody Student student)
 {
    String res=studentService.addStudent(student);
    return res;
 }
}

