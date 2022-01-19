package com.enocklubowa.airtelmoneyjava.model;

import com.enocklubowa.airtelmoneyjava.configuration.Properties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Details of the Airtel user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    private String country = Properties.airtel_country;
    private String currency = Properties.airtel_currency;
    private String msisdn;
}
