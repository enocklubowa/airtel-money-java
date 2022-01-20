package com.enocklubowa.airtelmoneyjava.service.product;

import com.enocklubowa.airtelmoneyjava.model.AirtelResponse;

import javax.validation.constraints.Size;

public interface Collection {
    AirtelResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            double amount,
            String transactionId);

    AirtelResponse refund(String transactionId);

    AirtelResponse checkStatus(String transactionId);
}
