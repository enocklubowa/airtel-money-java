package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.*;
import com.enocklubowa.airtelmoneyjava.service.product.Disbursement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.constraints.Size;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class DisbursementImpl implements Disbursement {

    private final AirtelWebClient webClient;

    private final ErrorCodeHandler errorCodeHandler;

    private final PinEncoder pinEncoder;

    @Override
    public AirtelResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            String pin,
            double amount,
            String id) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setId(id);

        Payee payee = new Payee(msisdn);


        TransferRequest request = new DisbursementRequest(
                reference, transaction, payee, pinEncoder.encode(pin));

        AirtelResponse response = webClient.build()
                .post()
                .uri("/standard/v1/disbursements/")
                .body(Mono.just(request), DisbursementRequest.class)
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
                .uri("/standard/v1/disbursements/{id}", id)
                .retrieve()
                .bodyToMono(AirtelResponse.class)
                .block();

        errorCodeHandler.checkForErrorResultCodes(response);

        return response;
    }
}
