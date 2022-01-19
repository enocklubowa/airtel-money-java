package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.model.ProductConstants;
import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;
import org.springframework.stereotype.Service;

@Service
public class AirtelErrorsHandler {

    public void checkForAirtelInternalErrors(CollectionResponse response) {
        for(String errorCode : ProductConstants.getErrors()){
            if(errorCode.equals(response.getStatus().getResult_code())){
                throw new CollectionException(response.getStatus().getResult_code()+": "+response.getStatus().getMessage());
            }
        }
    }
}
