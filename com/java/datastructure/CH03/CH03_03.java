package com.java.datastructure.CH03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class CH03_03 {

    public static void main(String[] args) {
        Random rand = new Random();
        ReverseStuLinkedList list = new ReverseStuLinkedList();
        int data[][] = new int[12][10];
        String name[] = new String[] { "Allen", "Scott", "Marry", "John", "Mark", "Jon", "Ricky", "Lisa", "Jessica",
                "Hanson", "Amy", "Bob", "Jack" };
        
        System.out.println("Student Number Score Studen Number Score ");
        for (int i = 0; i < 12; i++) {
            data[i][0] = i + 1;
            data[i][1] = (Math.abs(rand.nextInt(50))) + 50;
            list.insert(data[i][0], name[i], data[i][1]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("[" + data[j * 3 + i][0] + "][" +
             data[j * 3 + i][1] + "]");
                System.out.println();
            }
        }
        list.reversePrint();
    }

}

class ReverseStuLinkedList extends StuLinkedList {
    public void reversePrint() {
        StuNode current = first;
        StuNode before = null;
        System.out.println("List data after reversing: ");
        while (current != null) {
            last = before;
            before = current;
            current = current.getNext();
            before.setNext(last);
        }
        current = before;
        while (current != null) {
            System.out.println("[" + current.getData() + " " + current.getNames() + " " + current.getNp() + "]");
            current = current.getNext();
        }
        System.out.println();
    }
}