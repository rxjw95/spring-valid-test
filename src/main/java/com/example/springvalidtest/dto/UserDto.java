package com.example.springvalidtest.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private final String name;
    private final String id;
    private final String password;

    @Builder
    public UserDto(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
}
