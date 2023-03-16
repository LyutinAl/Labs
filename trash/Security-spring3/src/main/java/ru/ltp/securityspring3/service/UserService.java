package ru.ltp.securityspring3.service;

import ru.ltp.securityspring3.dto.UserDto;
import ru.ltp.securityspring3.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUser();
}
