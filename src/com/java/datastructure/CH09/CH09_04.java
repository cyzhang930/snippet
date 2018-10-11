package com.java.datastructure.CH09;

import java.util.Random;

public class CH09_04 {
    private static final int INDEX_BOX = 10;
    private static final int MAX_NUM = 7;

    public static void main(String[] args) {
        int[] index = new int[INDEX_BOX];
        int[] data = new int[MAX_NUM];
        Random rand = new Random();
        for (int i = 0; i < MAX_NUM; i++) {
            data[i] = (Math.abs(rand.nextInt(20))) + 1;
        }
        for (int i = 0; i < INDEX_BOX; i++) {
            index[i] = -1;
        }
        System.out.println("Original array:");
        printData(data);
        System.out.println("Try to create hash table:");
        for (int i = 0; i < MAX_NUM; i++) {
            createHashTable(data[i], index);
            System.out.print(" " + data[i] + " =>\t");
            printData(index);
        }
        System.out.println("Final hash table:");
        printData(index);
        
    }
    
    private static void printData(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();
    }
    
    private static void createHashTable(int data, int[] index) {
        int length = index.length;
        int tmp = data % length;
        while(true) {
            if (index[tmp] == -1) {
                index[tmp] = data;
                break;
            } else {
                tmp = (tmp + 1) % length;
            }
        }
    }

}
