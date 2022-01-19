package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CollectionService {

    private final AirtelWebClient webClient;

    public CollectionResponse makeCollection(String reference, String msisdn, Long amount, String transactionId){
        Subscriber subscriber = new Subscriber();
        subscriber.setMsisdn(msisdn);

        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setAmount(amount);

        CollectionRequest request = new CollectionRequest(reference, subscriber, transaction);

        return webClient.build()
                .post()
                .uri("/merchant/v1/payments/")
                .body(Mono.just(request), CollectionRequest.class)
                .retrieve()
                .bodyToMono(CollectionResponse.class)
                .block();
    }
}
