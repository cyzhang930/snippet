package com.java.test.datastructure.CH02;

import org.junit.*;
import org.junit.jupiter.api.Test;

import com.java.datastructure.CH02.CH02_06;

import static org.junit.Assert.*;

public class CH02_06Test {
    @Test
    public void testOK() throws Exception {
        int[][] array = { { 7, 8, 12, 21, 9 }, { 0, 5, 14, 17, 6 }, { 0, 0, 7, 23, 24 }, { 0, 0, 0, 32, 19 },
                { 0, 0, 0, 0, 8 } };
        CH02_06 object = new CH02_06();
        object.initAndTransformWithoutZero(array);
        assertEquals(object.getValue(4, 4), 8);
        assertEquals(object.getValue(4, 3), 0);
    }

    @Test
    public void shouldTestEmptyArrayException() {
        int[][] array = {};
        CH02_06 object = new CH02_06();
        try {
            object.initAndTransformWithoutZero(array);
            object.getValue(1, 1);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Empty array");
        }
    }
    
    @Test
    public void shouldTestInvalidElementException() {
        int[][] array = {{1, 2, 3}, {1}};
        CH02_06 object = new CH02_06();
        try {
            object.initAndTransformWithoutZero(array);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Element in row 1 is invalid");
        }
    }
    
    @Test
    public void shouldTestNullPointerException() {
        try {
            CH02_06 object = new CH02_06();
            object.getValue(0, 0);
        } catch (Exception e) {
            assertEquals(e.getClass(), NullPointerException.class);
        }
    }

}