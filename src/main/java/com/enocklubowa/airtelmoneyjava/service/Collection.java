package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;

import javax.validation.constraints.Size;

public interface Collection {
    CollectionResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            Long amount,
            String transactionId);

    CollectionResponse refund(String transactionId);

    CollectionResponse checkStatus(String transactionId);
}
