package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.RemittanceResponse;

public interface Remittance {
    RemittanceResponse checkEligibility(double amount, String msisdn);
}
