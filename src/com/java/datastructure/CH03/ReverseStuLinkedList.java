package com.java.datastructure.CH03;

public class ReverseStuLinkedList extends StuLinkedList {
    public void reverse() {
        StuNode current = first;
        StuNode before = null;
        while (current != null) {
            last = before;
            before = current;
            current = current.getNext();
            before.setNext(last);
        }
        first = before;
    }
}