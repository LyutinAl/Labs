package ru.ltp.securityspring3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ltp.securityspring3.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
