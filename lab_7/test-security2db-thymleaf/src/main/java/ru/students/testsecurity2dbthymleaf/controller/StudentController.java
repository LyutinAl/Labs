package ru.students.testsecurity2dbthymleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.students.testsecurity2dbthymleaf.entity.Student;
import ru.students.testsecurity2dbthymleaf.repository.StudentRepository;

import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepository studentRepositry;


    @GetMapping(value = {"/list", "/"})
    public ModelAndView getAllStudents() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-students");
        mav.addObject("students", studentRepositry.findAll());
        return mav;
    }

    @GetMapping(value = "/addStudentForm")
    public ModelAndView addStudentForm() {
        ModelAndView mav = new ModelAndView("add-student-form");
        Student student = new Student();
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping(value = "/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepositry.save(student);
        return "redirect:/list";
    }

    @GetMapping(value = "/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long studentId) {
        ModelAndView mav = new ModelAndView("add-student-form");
        Optional<Student> optionalStudent = studentRepositry.findById(studentId);
        Student student = new Student();
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        }
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping(value = "/deleteStudent")
    public String deleteStudent(@RequestParam Long studentId) {
        studentRepositry.deleteById(studentId);
        return "redirect:/list";
    }
}

