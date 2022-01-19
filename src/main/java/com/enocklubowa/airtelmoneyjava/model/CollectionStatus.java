package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Status object returned from Airtel about a given transaction/operation
 */
@Data
public class CollectionStatus {
    private String response_code;
    private String code;
    private boolean success;
    private String result_code;
    private String message;
}
