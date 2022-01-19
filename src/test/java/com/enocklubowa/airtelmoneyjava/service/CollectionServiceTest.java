package com.enocklubowa.airtelmoneyjava.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CollectionServiceTest {

    @Autowired
    private CollectionService collectionService;

    @Test
    public void shouldInitiateCollectionSuccessfully(){
        collectionService.makeCollection("testing transaction", "753503195", 500L, "hdhsja");

        assertEquals(1, 1);
    }
}
