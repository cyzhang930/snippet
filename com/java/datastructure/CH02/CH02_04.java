package com.java.datastructure.CH02;

import java.io.*;
import java.util.Scanner;

/*
 * Generate two-dimensional array, and revert it
 */

public class CH02_04 {
    Scanner in = new Scanner(System.in);

    public void setIn(ByteArrayInputStream baIn) {
        this.in = new Scanner(baIn);
    }

    public int[][] calculateWithInput() throws Exception {
        System.out.println("Create array A");
        int[][] arrA = createArrayWithInput();
        return revert(arrA);
    }

    public int[][] createArrayWithInput() {
        System.out.println("Please type the dimension of matrix: ");
        System.out.println("Please input the M of matrix: ");
        int dimensionM = Integer.parseInt(getInputLine());
        System.out.println("Get M:" + dimensionM);
        System.out.println("Please input the N of matrix: ");
        int dimensionN = Integer.parseInt(getInputLine());
        System.out.println("Get N:" + dimensionN);
        int array[][] = new int[dimensionM][dimensionN];
        System.out.println("Please input elements");
        for (int i = 0; i < dimensionM; i++) {
            for (int j = 0; j < dimensionN; j++) {
                System.out.print("array[" + i + "][" + j + "]=");
                array[i][j] = Integer.parseInt(getInputLine());
                System.out.print(array[i][j] + "\t");
            }
        }
        System.out.println();
        return array;
    }

    public String getInputLine() {
        return in.nextLine();
    }

    private int[][] revert(int[][] arrA) {
        int dimensionM = arrA[0].length;
        int dimensionN = arrA.length;
        if (dimensionM < 0 || dimensionN < 0) {
            // TBD
            return null;
        }
        int[][] arrB = new int[dimensionN][dimensionM];
        for (int i = 0; i < dimensionN; i++) {
            for (int j = 0; j < dimensionM; j++) {
                arrB[i][j] = arrA[j][i];
            }
        }
        return arrB;
    }
}
