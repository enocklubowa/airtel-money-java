package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class AirtelWebClient {
    private final static String CURRENCY_KEY = "X-Currency";
    private final static String COUNTRY_KEY = "X-Country";

    private final WebClient.Builder webClientBuilder;

    private final AuthService authService;

    public WebClient build(){
        return webClientBuilder.defaultHeaders(httpHeaders -> {
            httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.ALL_VALUE);
            httpHeaders.set(HttpHeaders.AUTHORIZATION, authService.getAccessToken().getAccess_token());
            httpHeaders.set(COUNTRY_KEY, Properties.airtel_country);
            httpHeaders.set(CURRENCY_KEY, Properties.airtel_currency);
        }).baseUrl(Properties.airtel_base_url).build();
    }
}
