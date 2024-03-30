package com.spring.admin.services;

import com.spring.admin.dto.UserDto;
import com.spring.admin.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto userDto);

    List<User> getAllUsers();
}
