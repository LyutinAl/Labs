package ru.ltp.securityspring3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ltp.securityspring3.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
