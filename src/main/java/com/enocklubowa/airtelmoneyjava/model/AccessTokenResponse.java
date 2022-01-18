package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;

/**
 * Object returned on requesting an authentication token from Airtel
 */
@Data
public class AccessTokenResponse {
    private String token_type;
    private String access_token;
    private Long expires_in;
}
