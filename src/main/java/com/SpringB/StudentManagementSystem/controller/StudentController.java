package com.SpringB.StudentManagementSystem.controller;

import com.SpringB.StudentManagementSystem.entity.Student;
import com.SpringB.StudentManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    StudentService service ;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public String firstPage(Model model){
        List<Student> myList = service.getStudents() ;
        model.addAttribute("students" , myList) ;
        return "mainPage" ;
    }

    @GetMapping("/student/new")
    public String newStdForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "savePage"  ;
    }

    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/student";
    }


    @GetMapping("/student/update/{id}")
    public String editStdForm(@PathVariable Long id, Model model){
        model.addAttribute("student", service.getById(id));
        return "editPage" ;
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        Student existingStudent = service.getById(id);
        existingStudent.setName(student.getName());
        existingStudent.setSurname(student.getSurname());
        existingStudent.setAge(student.getAge());

        // save updated student object
        service.updateStudent(existingStudent);
        return "redirect:/student";
    }

    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/student";
    }

}
