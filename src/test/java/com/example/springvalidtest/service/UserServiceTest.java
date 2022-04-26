package com.example.springvalidtest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService subject;

    @BeforeEach
    public void setUp() {
        subject = new UserService();
    }

    @Test
    public void createUserNonNullTest() {
        assertThrows(NullPointerException.class, () -> subject.createUser(null));
    }

}