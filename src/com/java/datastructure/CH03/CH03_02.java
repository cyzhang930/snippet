package com.java.datastructure.CH03;

import java.util.Random;

public class CH03_02 {
    public StuLinkedList deleteFromList(StuLinkedList list, int findword) throws Exception {
        StuNode current = new StuNode(list.first.getData(), list.first.getNames(), list.first.getNp());
        current.setNext(list.first.getNext());
        if (current != null) {
            while (current.getData() != findword) {
                current = current.getNext();
            }
            if (current.getData() == findword) {
                list.delete(current);
            }
        }
        return list;
    }

    public StuLinkedList createList(String[] name) throws Exception {
        if (name == null || name.length == 0) {
            throw new Exception("Invalid parameter");
        }
        int length = name.length;
        StuLinkedList list = new StuLinkedList();
        int data[][] = new int[length][2];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            data[i][0] = i + 1;
            data[i][1] = (Math.abs(rand.nextInt(50))) + 50;
            list.insert(data[i][0], name[i], data[i][1]);
        }
        return list;
    }
}
