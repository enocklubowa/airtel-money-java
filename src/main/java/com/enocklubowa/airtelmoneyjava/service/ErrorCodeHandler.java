package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.AirtelException;
import com.enocklubowa.airtelmoneyjava.model.CollectionErrorCodes;
import com.enocklubowa.airtelmoneyjava.model.AirtelResponse;

public class ErrorCodeHandler {

    public static void checkForErrorResultCodes(AirtelResponse response) {
        for(String errorCode : CollectionErrorCodes.getErrors()){
            if(errorCode.equals(response.getStatus().getResult_code())){
                throw new AirtelException(response.getStatus().getResult_code()+": "+response.getStatus().getMessage());
            }
        }
    }
}
