package com.karan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karan.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to my app" + request.getSession().getId();
    }

    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Karan", 60),
        new Student(2, "Chandan", 70),
        new Student(3, "Om", 90),
        new Student(4, "Rahul", 90),
        new Student(5, "Saad", 90)
    ));

    @GetMapping("/students")
    public List<Student> getStudent(){
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s){
        students.add(s);
        return s;
    }
}
