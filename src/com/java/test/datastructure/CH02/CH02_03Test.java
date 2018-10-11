package com.java.test.datastructure.CH02;

import java.io.ByteArrayInputStream;

import org.junit.*;

import com.java.datastructure.CH02.CH02_03;

import static org.junit.Assert.*;

public class CH02_03Test {
    CH02_03 object;

    @Before
    public void setUp() throws Exception {
        object = new CH02_03();
    }

    @Test
    public void testInput() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("2\n").append("2\n").append("1\n").append("2\n").append("3\n").append("4\n").append("2\n")
                .append("2\n").append("1\n").append("2\n").append("3\n").append("4\n");
        String data = sb.toString();
        ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes());
        object.setIn(input);
        int[][] result = object.calculateWithInput();
        assertEquals(result[0][0], 7);
        assertEquals(result[0][1], 10);
        assertEquals(result[1][0], 15);
        assertEquals(result[1][1], 22);
    }

}