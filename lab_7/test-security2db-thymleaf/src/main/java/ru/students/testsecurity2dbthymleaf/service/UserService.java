package ru.students.testsecurity2dbthymleaf.service;

import ru.students.testsecurity2dbthymleaf.dto.UserDto;
import ru.students.testsecurity2dbthymleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUser();
}
