package com.enocklubowa.airtelmoneyjava.exception;

import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;

public class CollectionStandardError extends RuntimeException{

    public CollectionStandardError(CollectionResponse response){
        super(response.getStatus().getResult_code() + " " + response.getStatus().getMessage());
    }
}
