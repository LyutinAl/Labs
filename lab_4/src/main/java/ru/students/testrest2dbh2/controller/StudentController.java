package ru.students.testrest2dbh2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.students.testrest2dbh2.entity.Student;
import ru.students.testrest2dbh2.service.StudentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")    // Т.к. для всех URI присутствует student, можно использовать для всего контроллера, что уменьшит код
public class StudentController {


    // Все анатации @Autowired заменил на @AllArgsConstructor для класса
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);    
        return student;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudent(id);
    }    
}
