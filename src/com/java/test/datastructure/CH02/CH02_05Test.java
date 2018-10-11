package com.java.test.datastructure.CH02;

import org.junit.*;

import com.java.datastructure.CH02.CH02_05;

import static org.junit.Assert.*;

public class CH02_05Test {
    CH02_05 object;
    int rows;
    int cols;
    int nonZeroNumber;

    @Before
    public void setUp() throws Exception {
        object = new CH02_05();
        rows = 8;
        cols = 9;
        nonZeroNumber = 8;
    }

    @Test
    public void testSparseArray() throws Exception {
        int[][] result = object.geneateSparseArray(rows, cols, nonZeroNumber);
        assertEquals(result.length, rows);
        assertEquals(result[0].length, cols);
    }

    @Test
    /*
     * Expected:
     *  9   8   8   
        1   1   5   
        1   6   4   
        2   5   3   
        3   4   7   
        3   8   1   
        5   7   6   
        6   2   8   
        6   7   2   
     */
    public void testCompressArray() throws Exception {
        int[][] sparse = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 5, 0, 0, 0, 0, 4, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
                { 0, 0, 0, 0, 7, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 6, 0 },
                { 0, 0, 8, 0, 0, 0, 0, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        int[][] result = object.geneateCompressArray(sparse, nonZeroNumber);
        assertEquals(result[0][0], cols);
        assertEquals(result[0][1], rows);
        assertEquals(result[0][2], nonZeroNumber);
        assertEquals(result[3][2], 3);
    }

}