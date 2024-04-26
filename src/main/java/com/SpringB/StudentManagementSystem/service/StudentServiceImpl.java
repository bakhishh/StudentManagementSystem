package com.SpringB.StudentManagementSystem.service;

import com.SpringB.StudentManagementSystem.entity.Student;
import com.SpringB.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    StudentRepository repo ;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
