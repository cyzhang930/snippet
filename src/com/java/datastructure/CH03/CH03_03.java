package com.java.datastructure.CH03;

import java.util.Random;

public class CH03_03 {
    ReverseStuLinkedList list = new ReverseStuLinkedList();

    public void setOriginList(String name[]) {
        Random rand = new Random();
        int length = name.length;
        int data[][] = new int[length][2];
        for (int i = 0; i < length; i++) {
            data[i][0] = i + 1;
            data[i][1] = (Math.abs(rand.nextInt(50))) + 50;
            this.list.insert(data[i][0], name[i], data[i][1]);
        }
    }

    public void revertList() {
        this.list.reverse();
    }

    public ReverseStuLinkedList getList() {
        return this.list;
    }
}