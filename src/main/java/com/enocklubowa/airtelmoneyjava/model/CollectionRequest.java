package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object sent when making a collection request
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionRequest {
    // Reason for the transaction e.g Testing transaction
    private String reference;
    private Subscriber subscriber;
    private Transaction transaction;
}
