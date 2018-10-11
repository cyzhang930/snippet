package com.java.datastructure.CH02;

import java.io.*;
import java.util.Scanner;

/*
 * Generate two two-dimensional array, and do multiplication
 */

public class CH02_03 {
    Scanner in = new Scanner(System.in);

    public void setIn(ByteArrayInputStream baIn) {
        this.in = new Scanner(baIn);
    }

    public int[][] calculateWithInput() throws Exception {
        System.out.println("Create array A");
        int[][] arrA = createArrayWithInput();
        System.out.println("Create array B");
        int[][] arrB = createArrayWithInput();
        return matrixMultiply(arrA, arrB);
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

    public int[][] matrixMultiply(int[][] arrA, int[][] arrB) {
        int dimensionM = arrA[0].length;
        int dimensionN = arrA.length;
        int dimensionP = arrB.length;
        int[][] arrC = new int[dimensionM][dimensionP];
        int i, j, k;
        if (dimensionM < 0 || dimensionN < 0 || dimensionP < 0) {
            // TBD
            return null;
        }
        for (i = 0; i < dimensionM; i++) {
            for (j = 0; j < dimensionP; j++) {
                for (k = 0; k < dimensionN; k++) {
                    arrC[i][j] += arrA[i][k] * arrB[k][j];
                }
            }
        }
        System.out.println("AxB result is");
        for (i = 0; i < dimensionM; i++) {
            for (j = 0; j < dimensionM; j++) {
                System.out.print(arrC[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return arrC;
    }
}
