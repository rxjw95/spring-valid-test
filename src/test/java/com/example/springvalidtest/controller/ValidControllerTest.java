package com.example.springvalidtest.controller;

import com.example.springvalidtest.controller.request.SignUpReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private SignUpReq signUpRequest;

    @Nested
    class ValidateFieldTest {

        @ParameterizedTest
        @ValueSource(strings = {"", "  "})
        @NullSource
        void nameValidTest(String name) throws Exception {

            signUpRequest = SignUpReq.builder()
                    .name(name)
                    .id("init")
                    .password("init")
                    .build();

            String jsonString = objectMapper.writeValueAsString(signUpRequest);

            mockMvc.perform(post("/api/v1/user/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonString))
                    .andExpect(status().isBadRequest());
        }


        @ParameterizedTest
        @ValueSource(strings = {"", "  "})
        @NullSource
        void idValidTest(String id) throws Exception {

            signUpRequest = SignUpReq.builder()
                    .name("init")
                    .id(id)
                    .password("init")
                    .build();

            String jsonString = objectMapper.writeValueAsString(signUpRequest);

            mockMvc.perform(post("/api/v1/user/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonString))
                    .andExpect(status().isBadRequest());
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "  "})
        @NullSource
        void passwordValid(String password) throws Exception {

            signUpRequest = SignUpReq.builder()
                    .name("init")
                    .id("init")
                    .password(password)
                    .build();

            String jsonString = objectMapper.writeValueAsString(signUpRequest);

            mockMvc.perform(post("/api/v1/user/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonString))
                    .andExpect(status().isBadRequest());
        }
    }
}