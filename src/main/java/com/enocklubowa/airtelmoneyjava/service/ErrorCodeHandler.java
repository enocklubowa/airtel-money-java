package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.model.CollectionErrorCodes;
import com.enocklubowa.airtelmoneyjava.model.AirtelResponse;
import org.springframework.stereotype.Service;

@Service
public class ErrorCodeHandler {

    public void checkForErrorResultCodes(AirtelResponse response) {
        for(String errorCode : CollectionErrorCodes.getErrors()){
            if(errorCode.equals(response.getStatus().getResult_code())){
                throw new CollectionException(response.getStatus().getResult_code()+": "+response.getStatus().getMessage());
            }
        }
    }
}
