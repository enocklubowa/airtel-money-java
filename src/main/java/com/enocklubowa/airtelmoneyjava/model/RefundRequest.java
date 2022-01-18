package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object sent when requesting a refund
 */
@Data
@NoArgsConstructor
public class RefundRequest {
    private Transaction transaction;
}
