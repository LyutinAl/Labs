package ru.students.testrest2dbh2.dao;

import java.util.List;

import ru.students.testrest2dbh2.entity.Student;

public interface StudentDAO {
    
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
