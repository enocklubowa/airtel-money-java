package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import com.enocklubowa.airtelmoneyjava.model.RemittanceRequest;
import com.enocklubowa.airtelmoneyjava.model.RemittanceResponse;
import com.enocklubowa.airtelmoneyjava.service.product.Remittance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RemittanceImpl implements Remittance {

    private final AirtelWebClient webClient;

    @Override
    public RemittanceResponse checkEligibility(double amount, String msisdn){
        RemittanceRequest request = new RemittanceRequest(
                amount,
                Properties.airtel_country,
                Properties.airtel_currency,
                msisdn);

        RemittanceResponse response = webClient.build()
                .post()
                .uri("/openapi/moneytransfer/v2/validate")
                .body(Mono.just(request), RemittanceRequest.class)
                .retrieve()
                .bodyToMono(RemittanceResponse.class)
                .block();

        return response;
    }
}
