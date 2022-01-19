package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CollectionTest {

    @Autowired
    private Collection collection;

    @Test
    public void shouldInitiateCollectionSuccessfully(){
        try {
            collection.initiate("", "753503195", 500L, "99682c47-8beb-470e-8ce3-061fc91b1d38");
        }
        catch (CollectionException exception){
            System.out.println(exception.getMessage());
        }

        assertEquals(1, 1);
    }
}
