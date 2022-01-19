package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import com.enocklubowa.airtelmoneyjava.model.AccessTokenRequest;
import com.enocklubowa.airtelmoneyjava.model.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final WebClient.Builder webClientBuilder;

    @Cacheable(value = "airtelAuthCache")
    public AccessTokenResponse getAccessToken(){
        AccessTokenRequest requestBody =
                new AccessTokenRequest(
                        Properties.airtel_client_id,
                        Properties.airtel_client_secret,
                        Properties.airtel_grant_type);

        ExchangeFilterFunction errorResponseFilter = ExchangeFilterFunction
                .ofResponseProcessor(ResponseHandler::responseProcessor);

        return webClientBuilder
                .defaultHeader(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(Properties.airtel_base_url)
                .filter(errorResponseFilter)
                .build()
                .post()
                .uri("/auth/oauth2/token")
                .body(Mono.just(requestBody), AccessTokenRequest.class)
                .retrieve()
                .bodyToMono(AccessTokenResponse.class)
                .block();
    }


}
