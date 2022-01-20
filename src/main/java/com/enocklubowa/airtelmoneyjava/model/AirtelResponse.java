package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirtelResponse {
    private ResponseData data;
    private ResponseStatus status;
}
