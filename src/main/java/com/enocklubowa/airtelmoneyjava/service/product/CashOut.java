package com.enocklubowa.airtelmoneyjava.service.product;

import com.enocklubowa.airtelmoneyjava.model.AirtelResponse;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public interface CashOut {
    AirtelResponse initiate(String msisdn, double amount, HashMap<String, String> additional_info, String reference, String id) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException;

    AirtelResponse checkStatus(String id);
}
