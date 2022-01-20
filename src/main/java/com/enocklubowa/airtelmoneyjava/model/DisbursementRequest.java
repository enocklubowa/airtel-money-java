package com.enocklubowa.airtelmoneyjava.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DisbursementRequest extends TransferRequest {
    private Payee payee;
    private String pin;

    public DisbursementRequest(Payee payee, String pin, String reference, Transaction transaction) {
        super(reference, transaction);
    }
}
