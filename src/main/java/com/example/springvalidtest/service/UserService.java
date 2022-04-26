package com.example.springvalidtest.service;

import com.example.springvalidtest.dto.UserDto;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String createUser(@NonNull UserDto user) {
        return "userId";
    }

}
