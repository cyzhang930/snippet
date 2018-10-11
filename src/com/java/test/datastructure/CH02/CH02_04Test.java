package com.java.test.datastructure.CH02;

import java.io.ByteArrayInputStream;

import org.junit.*;

import com.java.datastructure.CH02.CH02_04;

import static org.junit.Assert.*;

public class CH02_04Test {
    CH02_04 object;

    @Before
    public void setUp() throws Exception {
        object = new CH02_04();
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
        assertEquals(result[0][0], 1);
        assertEquals(result[0][1], 3);
        assertEquals(result[1][0], 2);
        assertEquals(result[1][1], 4);
    }

}