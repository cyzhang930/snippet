package com.java.datastructure.CH07;

import java.util.*;

public class TestCycle {

    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        DigraphString d = new DigraphString(list);
        d.addEdge("a", "b");
        d.addEdge("a", "d");
        d.addEdge("b", "c");
        d.addEdge("b", "d");
        d.addEdge("c", "d");
        d.addEdge("d", "e");
        d.addEdge("e", "c");
        //d.addEdge("e", "f");

        new DirectedCycleString(d);
    }

    // public static void main(String[] args) {
    // Digraph d = new Digraph(13);
    // d.addEdge(0, 5);
    // d.addEdge(0, 1);
    // d.addEdge(2, 0);
    // d.addEdge(2, 3);
    // d.addEdge(3, 2);
    // d.addEdge(3, 5);
    // d.addEdge(4, 2);
    // d.addEdge(4, 3);
    // d.addEdge(5, 4);
    // d.addEdge(6, 0);
    // d.addEdge(6, 4);
    // d.addEdge(6, 9);
    // d.addEdge(7, 6);
    // d.addEdge(7, 8);
    // d.addEdge(8, 7);
    // d.addEdge(8, 9);
    // d.addEdge(9, 10);
    // d.addEdge(9, 11);
    // d.addEdge(10, 12);
    // d.addEdge(11, 12);
    // d.addEdge(12, 9);
    //
    // new DirectedCycle(d);
    // }

}
