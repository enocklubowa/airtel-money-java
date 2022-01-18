package com.enocklubowa.airtelmoneyjava.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Properties {
    public static String airtel_client_id;
    public static String airtel_client_secret;
    public static String airtel_country;
    public static String airtel_currency;
    public static String airtel_base_url;
    public static String airtel_grant_type;

    @Autowired
    public Properties(
            @Value("${airtel_client_id}") String airtel_client_id,
            @Value("${airtel_client_secret}") String airtel_client_secret,
            @Value("${airtel_country}") String airtel_country,
            @Value("${airtel_currency}") String airtel_currency,
            @Value("${airtel_base_url}") String airtel_base_url,
            @Value("${airtel_grant_type}") String airtel_grant_type
    ){
        Properties.airtel_client_id = airtel_client_id;
        Properties.airtel_client_secret = airtel_client_secret;
        Properties.airtel_country = airtel_country;
        Properties.airtel_currency = airtel_currency;
        Properties.airtel_base_url = airtel_base_url;
        Properties.airtel_grant_type = airtel_grant_type;
    }
}
