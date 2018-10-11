package com.java.datastructure.CH09;

import java.util.Random;

public class CH09_05 {
    private static final int INDEX_BOX = 7;
    private static final int MAX_NUM = 13;
    private static Node[] indexTable = new Node[INDEX_BOX];

    public static void main(String[] args) {
        int[] data = new int[MAX_NUM];
        Random rand = new Random();
        System.out.println("Original array:");
        for (int i = 0; i < MAX_NUM; i++) {
            data[i] = (Math.abs(rand.nextInt(30))) + 1;
            System.out.print("[" + data[i] + "]\t");
            if (i % 8 == 7) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i = 0; i < INDEX_BOX; i++) {
            indexTable[i] =new Node(-1);
        }
        
        for (int i = 0; i < MAX_NUM; i++) {
            createHashTable(data[i]);
        }
        for (int i = 0; i < INDEX_BOX; i++) {
            printHashTable(i);
        }

    }
    
    private static void createHashTable(int data) {
        Node newNode = new Node(data);
        int hash = data % INDEX_BOX;
        Node currentNode = indexTable[hash];
        if (currentNode.getNext() == null) {
            currentNode.setNext(newNode);
        } else {
            while(currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }
    
    private static void printHashTable(int index) {
        Node head = indexTable[index].getNext();
        int i = 0;
        System.out.print(" " + index + ":\t");
        while (head != null) {
            System.out.print("[" + head.getVal() + "]-");
            i++;
            if (i % INDEX_BOX == 7) {
                System.out.println();
            }
            head = head.getNext();
        }
        System.out.println();
    }

}