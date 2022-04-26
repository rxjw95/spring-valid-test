package com.example.springvalidtest.controller;

import com.example.springvalidtest.controller.request.SignUpReq;
import com.example.springvalidtest.controller.response.SignUpRes;
import com.example.springvalidtest.dto.UserDto;
import com.example.springvalidtest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
class ValidController {

    private final UserService userService;

    public ValidController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpRes> signUp(@Valid @RequestBody final SignUpReq signUpRequest) {

        String id = userService.createUser(UserDto.builder()
                .name(signUpRequest.getName())
                .id(signUpRequest.getId())
                .password(signUpRequest.getPassword())
                .build());

        return ResponseEntity.ok(SignUpRes.builder().id(id).build());
    }

}