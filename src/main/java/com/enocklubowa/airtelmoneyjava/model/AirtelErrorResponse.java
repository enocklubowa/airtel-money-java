package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;

/**
 * Object returned on error
 */
@Data
public class AirtelErrorResponse {
    private String error_description;
    private String error;
}
