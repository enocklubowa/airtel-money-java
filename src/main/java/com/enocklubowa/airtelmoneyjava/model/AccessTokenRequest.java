package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Object sent when requesting an access token
 */
@Data
@AllArgsConstructor
public class AccessTokenRequest {
    private String client_id;
    private String client_secret;
    private String grant_type;
}
