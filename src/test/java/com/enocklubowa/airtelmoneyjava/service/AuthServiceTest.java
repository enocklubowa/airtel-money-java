package com.enocklubowa.airtelmoneyjava.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void shouldReturnAccessToken(){
        System.out.println(authService.getAccessToken());

        assertEquals(1, 1);
    }
}
