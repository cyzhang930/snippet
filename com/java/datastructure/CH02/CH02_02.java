package com.java.datastructure.CH02;

/*
 * The two matrix addition operations
 */
public class CH02_02 {
    public int[][] matrixAdd(int arrA[][], int arrB[][], int dimX, int dimY) throws Exception {
        int[][] arrC = new int[dimX][dimY];
        int row, col;
        if (dimX <= 0 || dimY <= 0) {
            throw new Exception("Wrong matrix parameter");
        }

        for (row = 1; row <= dimX; row++) {
            for (col = 1; col <= dimY; col++) {
                arrC[row - 1][col - 1] = arrA[row - 1][col - 1] + arrB[row - 1][col - 1];
            }
        }
        return arrC;
    }

}
