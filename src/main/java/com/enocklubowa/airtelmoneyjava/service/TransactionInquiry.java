package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionInquiry {

    private final AirtelWebClient webClient;

    private final AirtelErrorsHandler airtelErrorsHandler;

    public CollectionResponse make(String transactionId){

        CollectionResponse response = webClient.build()
                .get()
                .uri("/standard/v1/payments/{id}", transactionId)
                .retrieve()
                .bodyToMono(CollectionResponse.class)
                .block();

        airtelErrorsHandler.checkForAirtelInternalErrors(response);

        return response;
    }
}
