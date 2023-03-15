package com.example.testthymeleafwebapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testthymeleafwebapp.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Long> {
    
}
