package com.java.datastructure.CH02;

public class CH02_05 {

    public int[][] geneateSparseArray(int rows, int cols, int nonZeroNumber) {
        int sparse[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                sparse[i][j] = 0;
            }
        }
        int tempRow = 0;
        int tempCol = 0;
        int randomLen = nonZeroNumber + 1;
        for (int i = 0; i < randomLen; i++) {
            tempRow = (int) (Math.random() * 100);
            tempRow = tempRow % rows;
            tempCol = (int) (Math.random() * 100);
            tempCol = tempCol % cols;
            if (sparse[tempRow][tempCol] != 0) {
                randomLen++;
            }
            sparse[tempRow][tempCol] = i;
        }
        System.out.println("Elements in the sparse:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sparse[i][j] + "\t");
            }
            System.out.println();
        }
        return sparse;
    }

    public int[][] geneateCompressArray(int[][] sparse, int nonZeroNumber) {
        int rows = sparse.length;
        int cols = sparse[0].length;
        int[][] compress = new int[nonZeroNumber + 1][3];
        compress[0][0] = sparse[0].length;
        compress[0][1] = sparse.length;
        compress[0][2] = nonZeroNumber;

        int temp = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sparse[i][j] != 0) {
                    compress[temp][0] = i;
                    compress[temp][1] = j;
                    compress[temp][2] = sparse[i][j];
                    temp++;
                }
            }
        }

        System.out.println("compress matrix:");
        for (int i = 0; i < compress.length; i++) {
            for (int j = 0; j < compress[0].length; j++) {
                System.out.print(compress[i][j] + "\t");
            }
            System.out.println();
        }
        return compress;
    }

}
