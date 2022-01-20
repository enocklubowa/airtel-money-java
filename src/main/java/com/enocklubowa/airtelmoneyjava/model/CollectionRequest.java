package com.enocklubowa.airtelmoneyjava.model;

import lombok.*;

/**
 * Object sent when making a collection request
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionRequest extends TransferRequest {
    private Subscriber subscriber;

    public CollectionRequest(Subscriber subscriber, String reference, Transaction transaction){
        super(reference, transaction);
        this.subscriber = subscriber;
    }
}
