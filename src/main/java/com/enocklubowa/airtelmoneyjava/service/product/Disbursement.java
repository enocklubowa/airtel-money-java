package com.enocklubowa.airtelmoneyjava.service.product;

import com.enocklubowa.airtelmoneyjava.model.AirtelResponse;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.constraints.Size;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface Disbursement {
    AirtelResponse initiate(
            @Size(min = 2, max = 10, message = "reference should have at least 4 and a maximum of 64 characters") String reference,
            @Size(min = 9, max = 9, message = "msisdn should contain 9 characters") String msisdn,
            String pin,
            double amount,
            String id) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException;

    AirtelResponse checkStatus(String id);
}
