package com.enocklubowa.airtelmoneyjava.model;

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
    private String country;
    private String currency;
    private String msisdn;
}
