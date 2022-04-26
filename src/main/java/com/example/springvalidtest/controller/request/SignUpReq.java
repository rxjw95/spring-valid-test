package com.example.springvalidtest.controller.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class SignUpReq {
    @NotNull(message = "null일 수 없습니다.")
    private String name;

    @NotEmpty(message = "null이거나 빈 문자열일 수 없습니다.")
    private String id;

    @NotBlank(message = "null이거나 빈 문자열이거나 공백 문자열일 수 없습니다.")
    private String password;

    @Builder
    public SignUpReq(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }
}