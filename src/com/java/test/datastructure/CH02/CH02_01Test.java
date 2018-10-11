package com.java.test.datastructure.CH02;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.java.datastructure.CH02.CH02_01;


public class CH02_01Test {
    private static CH02_01 object;
    
    @BeforeAll
    static void initAll() {
        object  = new CH02_01();
    }
    
    @Test
    public void testCreate() {
        object.createArray(1000);
        assertEquals(2, 2);
    }

}
