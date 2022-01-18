package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Details about the transaction
 */
@Data
@NoArgsConstructor
public class Transaction {
    private String amount;
    private String country;
    private String currency;
    private String id;
    private String status;
    private String airtel_money_id;
    private String message;
}
