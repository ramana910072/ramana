package com.user.user.service;

import com.user.user.dto.UserDto;

public interface UserService {
    UserDto getUserWithMessages(int sendFrom);

    UserDto addUser(UserDto userDto);
}
