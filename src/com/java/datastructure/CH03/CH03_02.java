package com.java.datastructure.CH03;

import java.io.*;
import java.util.Random;

public class CH03_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();
        StuLinkedList list = new StuLinkedList();
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
        while (true) {
            System.out.println("Please input the student number to be deleted: ");
            int findword = Integer.parseInt(buf.readLine());
            if (findword == -1) {
                break;
            } else {
                StuNode current = new StuNode(list.first.getData(), list.first.getNames(), list.first.getNp());
                current.setNext(list.first.getNext());
                while (current.getData() != findword) {
                    current = current.getNext();
                    list.delete(current);
                }
            }
            
        }
        
        System.out.println("Student score");
        System.out.println("Student name and score ====");
        list.print();
    }
}
