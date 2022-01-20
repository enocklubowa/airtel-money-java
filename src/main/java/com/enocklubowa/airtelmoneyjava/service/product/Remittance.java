package com.enocklubowa.airtelmoneyjava.service.product;

import com.enocklubowa.airtelmoneyjava.model.RemittanceResponse;

public interface Remittance {
    RemittanceResponse checkEligibility(double amount, String msisdn);
}
