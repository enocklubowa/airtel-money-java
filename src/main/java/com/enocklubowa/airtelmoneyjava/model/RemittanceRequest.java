package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemittanceRequest {
    private double amount;
    private String country;
    private String currency;
    private String msisdn;
}
