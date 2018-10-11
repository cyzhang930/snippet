package com.java.datastructure.CH07;

public class CH07_01 {

    public static void main(String[] args) {
        int[][] data = { { 1, 2 }, { 2, 1 }, { 1, 5 }, { 5, 1 }, { 2, 3 }, { 3, 2 }, { 2, 4 }, { 4, 2 }, { 3, 4 },
                { 4, 3 }, { 3, 5 }, { 5, 3 }, { 4, 5 }, { 5, 4 } };
        
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j< 6; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    int tempi = data[i][0];
                    int tempj = data[i][1];
                    arr[tempi][tempj] = 1;
                }
            }
        }
        System.out.println("Matrix:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j< 6; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }

}
