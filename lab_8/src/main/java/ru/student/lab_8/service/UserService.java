package ru.student.lab_8.service;

import ru.student.lab_8.dto.UserDto;
import ru.student.lab_8.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUser();
}
