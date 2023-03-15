package ru.students.testsecurity2dbthymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.students.testsecurity2dbthymleaf.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
