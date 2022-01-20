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
    private double amount;
    private String country = Properties.airtel_country;
    private String currency = Properties.airtel_currency;
    private String id;
    private String status;
    //only for refunds
    private String airtel_money_id;
    private String message;
    private String reference_id;

    public String getStatus(){
        try {
            switch (this.status){
                case "TS":
                    return "Transaction Failed";
                case "TA":
                    return "Transaction Ambiguous";
                case "TIP":
                    return "Transaction in Progress";
                default:
                    return this.status;
            }
        }
        catch (Exception exception){
            return null;
        }
    }
}
