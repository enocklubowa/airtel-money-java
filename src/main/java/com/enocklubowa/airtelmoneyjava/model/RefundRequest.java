package com.enocklubowa.airtelmoneyjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object sent when requesting a refund
 */
@Data
@AllArgsConstructor
public class RefundRequest {
    private Transaction transaction;
}
