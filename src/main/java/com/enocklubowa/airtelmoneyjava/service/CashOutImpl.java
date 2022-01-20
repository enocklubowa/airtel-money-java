package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.*;
import com.enocklubowa.airtelmoneyjava.service.product.CashOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CashOutImpl implements CashOut {

    private final AirtelWebClient webClient;

    @Override
    public AirtelResponse initiate(String msisdn, double amount, HashMap<String, String> additional_info, String reference, String id) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        List<AdditionalInfoItem> additionalInfoItems = AdditionalInfoParser.parseAdditionalInfo(additional_info);

        Subscriber subscriber = new Subscriber();
        subscriber.setMsisdn(msisdn);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setId(id);

        TransferRequest request = new CashOutRequest(
                additionalInfoItems,
                subscriber,
                reference,
                transaction);

        AirtelResponse response = webClient.build()
                .post()
                .uri("/standard/v1/cashout/")
                .body(Mono.just(request), TransferRequest.class)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        ErrorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }

    @Override
    public AirtelResponse checkStatus(String id){
        AirtelResponse response = webClient.build()
                .get()
                .uri("/standard/v1/payments/{id}", id)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        ErrorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }

}
