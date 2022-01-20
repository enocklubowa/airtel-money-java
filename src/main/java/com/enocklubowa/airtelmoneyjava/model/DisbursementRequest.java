package com.enocklubowa.airtelmoneyjava.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class DisbursementRequest extends TransferRequest {
    private Payee payee;
    private String pin;

    public DisbursementRequest(String reference, Transaction transaction, Payee payee, String pin){
        super(reference, transaction);
        this.payee = payee;
        this.pin = pin;
    }

}
