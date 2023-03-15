package ru.students.testsecurity2dbthymleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.students.testsecurity2dbthymleaf.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
