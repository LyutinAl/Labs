package ru.students.testrest2dbh2.service;

import java.util.List;

import ru.students.testrest2dbh2.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
