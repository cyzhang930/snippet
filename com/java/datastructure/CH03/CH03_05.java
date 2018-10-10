package com.java.datastructure.CH03;

import java.util.Random;

public class CH03_05 {

    public static void main(String[] args) {
        Random rand = new Random();
        ConcatStuLinkedList list1 = new ConcatStuLinkedList();
        StuLinkedList list2 = new StuLinkedList();
        int[][] data = new int[12][10];
        String[] name1 = new String[] { "Allen", "Scott", "Marry", "John", "Mark", "Jon", "Ricky", "Lisa" };
        String[] name2 = new String[] { "Tessy", "Welson", "Jessie", "Jessica", "Hanson", "Amy", "Bob", "Jack" };
        for (int i = 0; i < 8; i++) {
            data[i][0] = i + 1;
            data[i][1] = (Math.abs(rand.nextInt(50))) + 50;
            list1.insert(data[i][0], name1[i], data[i][1]);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + data[j + i * 4][0] + "][" + data[j + i * 4][1] + "]");
            }
            System.out.println();
        }
        for (int i = 0; i < 8; i++) {
            data[i][0] = i + 9;
            data[i][1] = (Math.abs(rand.nextInt(50))) + 50;
            list2.insert(data[i][0], name2[i], data[i][1]);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + data[j + i * 4][0] + "][" + data[j + i * 4][1] + "]");
            }
        }
        list1.concat(list2);
        list1.print();
    }

}

class ConcatStuLinkedList extends StuLinkedList {
    public StuLinkedList concat(StuLinkedList stuList) {
        this.last.setNext(stuList.first);
        this.last = stuList.last;
        this.last.setNext(this.first);
        return this;
    }
}