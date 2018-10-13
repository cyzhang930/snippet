package com.java.test.datastructure.CH03;

import com.java.datastructure.CH03.StuLinkedList;

import org.junit.*;

import com.java.datastructure.CH03.CH03_02;

import static org.junit.Assert.*;

public class CH03_02Test {
    CH03_02 object;

    @Before
    public void setUp() throws Exception {
        object = new CH03_02();
    }

    @Test
    public void testInput() throws Exception {
        String[] name = new String[] { "Allen", "Scott", "Marry", "John", "Mark", "Jon", "Ricky", "Lisa", "Jessica",
                "Hanson", "Amy", "Bob", "Jack" };
        StuLinkedList result = object.createList(name);
        assertEquals(result.isEmpty(), false);
        for (int i = 0; i < name.length; i++) {
            object.deleteFromList(result, i + 1);
        }
        assertEquals(result.isEmpty(), true);
    }

    @Test
    public void testInvalidParemeterException() {
        try {
            object.createList(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid parameter");
        }
    }
}