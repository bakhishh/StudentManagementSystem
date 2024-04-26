package com.SpringB.StudentManagementSystem.repository;

import com.SpringB.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
