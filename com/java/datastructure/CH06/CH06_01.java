package com.java.datastructure.CH06;

public class CH06_01 {

    public static void main(String[] args) {
        int[] data= {6, 3, 5, 9, 7, 8, 4, 2};
        int[] bTree = new int[16];
        
        for (int i = 0; i < 16; i++) {
            bTree[i] = 0;
        }
        System.out.println("Original data is:");
        for (int i = 0; i < 8; i++) {
            System.out.print("[" + data[i] + "]\t");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            int level;
            for (level = 1; bTree[level] !=0;) {
                if (data[i] > bTree[level]) {
                    level = level * 2 + 1;
                } else {
                    level = level * 2;
                }
            }
            bTree[level] = data[i];
        }
        System.out.println("BTree data is:");
        for (int i = 1; i < 16; i++) {
            System.out.print("[" + bTree[i] + "]\t");
        }
        System.out.println();
    }

}
