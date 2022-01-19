package com.enocklubowa.airtelmoneyjava.model;

import java.util.List;

public class ProductConstants {

    public static List<String> getErrors(){
        return List.of(
                "ESB000001",
                "ESB000004",
                "ESB000008",
                "ESB000011",
                "ESB000014",
                "ESB000033",
                "ESB000034",
                "ESB000035",
                "ESB000036",
                "ESB000039",
                "ESB000041",
                "ESB000045",
                "ROUTER001",
                "ROUTER003",
                "ROUTER005",
                "ROUTER006",
                "ROUTER007",
                "ROUTER112",
                "ROUTER114",
                "ROUTER115",
                "ROUTER116",
                "ROUTER117");
    }

    public static List<String> getAvailableTransactionStatus(){
        return List.of("TS", "TA", "TIP");
    }

}
