package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.CollectionRequest;
import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;
import com.enocklubowa.airtelmoneyjava.model.RefundRequest;
import com.enocklubowa.airtelmoneyjava.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class Refund {

    private final AirtelWebClient webClient;

    private final AirtelErrorsHandler airtelErrorsHandler;

    public CollectionResponse make(String transactionId){
        Transaction transaction = new Transaction();
        transaction.setAirtel_money_id(transactionId);
        RefundRequest request = new RefundRequest(transaction);

        CollectionResponse response = webClient.build()
                .post()
                .uri("/standard/v1/payments/refund")
                .body(Mono.just(request), CollectionRequest.class)
                .retrieve()
                .bodyToMono(CollectionResponse.class)
                .block();

        airtelErrorsHandler.checkForAirtelInternalErrors(response);

        return response;
    }
}
