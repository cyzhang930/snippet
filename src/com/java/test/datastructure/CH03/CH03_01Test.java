package com.java.test.datastructure.CH03;

import java.io.ByteArrayInputStream;
import com.java.datastructure.CH03.LinkedList;

import org.junit.*;

import com.java.datastructure.CH03.CH03_01;

import static org.junit.Assert.*;

public class CH03_01Test {
    CH03_01 object;

    @Before
    public void setUp() throws Exception {
        object = new CH03_01();
    }

    @Test
    public void testInput() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("1\n").append("Amy\n").append("100\n").append("2\n").append("Eddy\n").append("60\n");
        String data = sb.toString();
        ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes());
        object.setIn(input);
        LinkedList result = object.createListWithInput(2);
        assertEquals(result.getNameInNode(result.getFirst()), "Amy");
        assertEquals(result.getNameInNode(result.getLast()), "Eddy");
    }

    @Test
    public void testInvalidParemeterException() {
        try {
            object.createListWithInput(-1);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid parameter");
        }
    }

    @Test
    public void testInvalidInputException() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("1\n").append("Amy\n").append("xxx\n").append("2\n").append("Eddy\n").append("60\n");
            String data = sb.toString();
            ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes());
            object.setIn(input);
            object.createListWithInput(2);
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }
}