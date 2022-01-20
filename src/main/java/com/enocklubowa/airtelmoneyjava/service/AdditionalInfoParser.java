package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.model.AdditionalInfoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdditionalInfoParser {

    public static List<AdditionalInfoItem> parseAdditionalInfo(HashMap<String, String> additional_info) {
        List<AdditionalInfoItem> items = new ArrayList<>();
        for(Map.Entry<String, String> entry: additional_info.entrySet()){
            items.add(new AdditionalInfoItem(entry.getKey(), entry.getValue()));
        }
        return items;
    }
}
