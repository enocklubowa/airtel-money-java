package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Size;

@Service
@RequiredArgsConstructor
public class Collection {

    private final AirtelWebClient webClient;

    private final AirtelErrorsHandler airtelErrorsHandler;

    public CollectionResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            Long amount,
            String transactionId){
        Subscriber subscriber = new Subscriber();
        subscriber.setMsisdn(msisdn);

        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setAmount(amount);

        CollectionRequest request = new CollectionRequest(reference, subscriber, transaction);

        CollectionResponse response = webClient.build()
                .post()
                .uri("/merchant/v1/payments/")
                .body(Mono.just(request), CollectionRequest.class)
                .retrieve()
                .bodyToMono(CollectionResponse.class)
                .block();

        airtelErrorsHandler.checkForAirtelInternalErrors(response);

        return response;
    }

}
