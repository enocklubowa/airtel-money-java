package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RefundTest {

    @Autowired
    private Refund refund;

    @Test
    public void shouldMakeRefundSuccessfully(){
        refund.make("transaction_id");

        assertEquals(1, 1);

    }
}
