package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.*;
import com.enocklubowa.airtelmoneyjava.service.product.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Size;

@Service
@RequiredArgsConstructor
public class CollectionImpl implements Collection {

    private final AirtelWebClient webClient;

    @Override
    public AirtelResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            double amount,
            String transactionId){
        Subscriber subscriber = new Subscriber();
        subscriber.setMsisdn(msisdn);

        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setAmount(amount);

        TransferRequest request = new CollectionRequest(subscriber, reference, transaction);

        AirtelResponse response = webClient.build()
                .post()
                .uri("/merchant/v1/payments/")
                .body(Mono.just(request), CollectionRequest.class)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        ErrorCodeHandler.checkForErrorResultCodes(response);
        return response;
    }


    @Override
    public AirtelResponse refund(String transactionId){
        Transaction transaction = new Transaction();
        transaction.setAirtel_money_id(transactionId);
        RefundRequest request = new RefundRequest(transaction);

        AirtelResponse response = webClient.build()
                .post()
                .uri("/standard/v1/payments/refund")
                .body(Mono.just(request), RefundRequest.class)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        ErrorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }

    @Override
    public AirtelResponse checkStatus(String transactionId){

        AirtelResponse response = webClient.build()
                .get()
                .uri("/standard/v1/payments/{id}", transactionId)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        ErrorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }

}
