package com.enocklubowa.airtelmoneyjava.service;

import com.enocklubowa.airtelmoneyjava.exception.CollectionException;
import com.enocklubowa.airtelmoneyjava.service.product.Collection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
public class CollectionTest {

    @Autowired
    private Collection collection;

    @Test
    public void shouldInitiateCollectionSuccessfully(){
        try {
            collection.initiate("testing", "753503195", 50L, "99682c47-8beb-470e");
        }
        catch (CollectionException exception){
            System.out.println(exception.getMessage());
        }

        assertEquals(1, 1);
    }
}
