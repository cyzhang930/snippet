package com.java.datastructure.CH07;

public class CH07_02 {

    public static void main(String[] args) {
        int[][] data = { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };

        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int tempi = data[i][0];
                int tempj = data[i][1];
                arr[tempi][tempj] = 1;
            }
        }
        System.out.println("Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }

}
