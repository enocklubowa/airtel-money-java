package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CashInRequest extends CollectionRequest{
    private String pin;
    private List<AdditionalInfoItem> additional_info;

    public CashInRequest(String pin, List<AdditionalInfoItem> additional_info, Subscriber subscriber, String reference, Transaction transaction){
        super(subscriber, reference, transaction);
        this.pin = pin;
        this.additional_info = additional_info;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class AdditionalInfoItem{
        private String key;
        private String value;
    }
}
