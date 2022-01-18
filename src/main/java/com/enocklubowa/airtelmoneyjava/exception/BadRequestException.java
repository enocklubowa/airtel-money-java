package com.enocklubowa.airtelmoneyjava.exception;

import com.enocklubowa.airtelmoneyjava.model.AirtelErrorResponse;

public class BadRequestException extends RuntimeException{

    public BadRequestException(){
        super("Invalid value provided");
    }
    public BadRequestException(AirtelErrorResponse error){
        super(error.getError()+": "+error.getError_description());
    }
}
