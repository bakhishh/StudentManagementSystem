package com.SpringB.StudentManagementSystem.service;

import com.SpringB.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents() ;

    Student saveStudent(Student student) ;

    Student getById(Long id) ;

    Student updateStudent(Student student)  ;

    void deleteById(Long id) ;

}
