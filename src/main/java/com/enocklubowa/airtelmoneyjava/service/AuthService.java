package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.AccessTokenRequest;
import com.enocklubowa.airtelmoneyjava.model.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final WebClient.Builder webClientBuilder;


    public AccessTokenResponse getAccessToken(){
        webClientBuilder.build()
                .post()
                .uri()
                .retrieve()
                .bodyToMono()
                .block()
    }
}
