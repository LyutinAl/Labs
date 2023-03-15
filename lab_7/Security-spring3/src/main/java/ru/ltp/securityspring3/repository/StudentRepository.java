package ru.ltp.securityspring3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ltp.securityspring3.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
