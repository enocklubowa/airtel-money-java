package com.enocklubowa.airtelmoneyjava.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CashOutRequest extends CollectionRequest{
    private List<AdditionalInfoItem> additional_info;

    public CashOutRequest(List<AdditionalInfoItem> additional_info, Subscriber subscriber, String reference, Transaction transaction){
        super(subscriber, reference, transaction);
        this.additional_info = additional_info;
    }

}
