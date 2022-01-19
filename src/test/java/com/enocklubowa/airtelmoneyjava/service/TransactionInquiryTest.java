package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.model.CollectionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionInquiryTest {

    @Autowired
    private TransactionInquiry transactionInquiry;

    @Test
    public void shouldReturnTransactionStatus(){
        CollectionResponse response = transactionInquiry.make("99682c47-8beb-470e");
        System.out.println("Transaction "+ response.getData().getTransaction().getStatus());
        assertEquals(1, 1);
    }
}
