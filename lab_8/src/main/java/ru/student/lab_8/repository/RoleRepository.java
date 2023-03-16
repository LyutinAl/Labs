package ru.student.lab_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.lab_8.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
