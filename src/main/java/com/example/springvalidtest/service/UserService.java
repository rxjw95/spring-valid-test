package com.example.springvalidtest.service;

import com.example.springvalidtest.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String createUser(UserDto user) {
        return user.getId();
    }
}
