package com.enocklubowa.airtelmoneyjava.model;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Details about the transaction
 */
@Data
@NoArgsConstructor
public class Transaction {
    private Long amount;
    private String country = Properties.airtel_country;
    private String currency = Properties.airtel_currency;
    private String id;
    private String status;
    //only for refunds
    private String airtel_money_id;
    private String message;
}
