package com.java.test.datastructure.CH02;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.java.datastructure.CH02.CH02_02;

public class CH02_02Test {
    private static CH02_02 object;

    @BeforeAll
    static void initAll() {
        object = new CH02_02();
    }

    @Test
    public void testAdd() throws Exception {
        int[][] addA = { { 1, 3, 5 }, { 7, 9, 11 }, { 13, 15, 17 } };
        int[][] addB = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int rows = 3;
        int cols = 3;
        int[][] addC = object.matrixAdd(addA, addB, rows, cols);
        assertEquals(18, addC[rows - 1][cols - 1]);
    }

    @Test
    public void shouldTestExceptionMessage1() {
        int[][] addA = { { 1, 3, 5 }, { 7, 9, 11 }, { 13, 15, 17 } };
        int[][] addB = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int rows = 0;
        int cols = 3;
        try {
            object.matrixAdd(addA, addB, rows, cols);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Wrong matrix parameter");
        }
    }

    @Test
    public void shouldTestExceptionMessag2() {
        int[][] addA = { { 1, 3, 5 }, { 7, 9, 11 }, { 13, 15, 17 } };
        int[][] addB = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int rows = 0;
        int cols = 0;
        try {
            object.matrixAdd(addA, addB, rows, cols);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Wrong matrix parameter");
        }
    }

    @Test
    public void shouldTestExceptionMessage3() {
        int[][] addA = { { 1, 3, 5 }, { 7, 9, 11 }, { 13, 15, 17 } };
        int[][] addB = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int rows = 3;
        int cols = 0;
        try {
            object.matrixAdd(addA, addB, rows, cols);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Wrong matrix parameter");
        }
    }

}
