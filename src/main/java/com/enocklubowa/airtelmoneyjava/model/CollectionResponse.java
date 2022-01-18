package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CollectionResponse {
    private AirtelResponseData data;
    private AirtelResponseStatus status;
}
