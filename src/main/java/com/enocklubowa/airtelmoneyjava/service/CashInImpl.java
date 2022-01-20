package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CashInImpl implements CashIn {

    private final AirtelWebClient webClient;

    private final ErrorCodeHandler errorCodeHandler;

    private final PinEncoder pinEncoder;

    @Override
    public AirtelResponse initiate(String msisdn, double amount, HashMap<String, String> additional_info, String reference, String pin, String id) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        List<CashInRequest.AdditionalInfoItem> additionalInfoItems = parseAdditionalInfo(additional_info);

        Subscriber subscriber = new Subscriber();
        subscriber.setMsisdn(msisdn);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setId(id);

        TransferRequest request = new CashInRequest(
                pinEncoder.encode(pin),
                additionalInfoItems,
                subscriber,
                reference,
                transaction);

        AirtelResponse response = webClient.build()
                .post()
                .uri("/standard/v1/cashin/")
                .body(Mono.just(request), TransferRequest.class)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        errorCodeHandler.checkForErrorResultCodes(response);

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

        errorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }

    private List<CashInRequest.AdditionalInfoItem> parseAdditionalInfo(HashMap<String, String> additional_info) {
        List<CashInRequest.AdditionalInfoItem> items = new ArrayList<>();
        for(Map.Entry<String, String> entry: additional_info.entrySet()){
            items.add(new CashInRequest.AdditionalInfoItem(entry.getKey(), entry.getValue()));
        }
        return items;
    }

}