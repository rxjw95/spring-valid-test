package com.example.springvalidtest.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpRes {
    private final String id;

    @Builder
    public SignUpRes(String id) {
        this.id = id;
    }
}
