package com.enocklubowa.airtelmoneyjava.model;

import lombok.*;

/**
 * Object sent when making a collection request
 */
@Getter
@Setter
@NoArgsConstructor
public class CollectionRequest extends TransferRequest {
    private Subscriber subscriber;

    public CollectionRequest(String reference, Subscriber subscriber, Transaction transaction){
        super(reference, transaction);
        this.subscriber = subscriber;
    }
}
