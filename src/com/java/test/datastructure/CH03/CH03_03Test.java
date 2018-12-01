package com.java.test.datastructure.CH03;

import com.java.datastructure.CH03.StuLinkedList;

import org.junit.*;

import com.java.datastructure.CH03.CH03_03;
import com.java.datastructure.CH03.ReverseStuLinkedList;

import static org.junit.Assert.*;

public class CH03_03Test {
    CH03_03 object;
    String[] name = new String[] { "Allen", "Scott", "Marry", "John", "Mark", "Jon", "Ricky", "Lisa", "Jessica",
            "Hanson", "Amy", "Bob", "Jack" };

    @Before
    public void setUp() throws Exception {
        object = new CH03_03();
        object.setOriginList(name);
    }

    @Test
    public void testCreateOriginal() throws Exception {
        ReverseStuLinkedList result = object.getList();
        assertEquals(result.getFirstName(), "Allen");
    }

    @Test
    public void testReverseOriginal() throws Exception {
        object.revertList();
        ReverseStuLinkedList result = object.getList();
        assertEquals(result.getFirstName(), "Jack");
    }
}