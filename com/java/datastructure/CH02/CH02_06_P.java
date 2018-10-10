package com.java.datastructure.CH02;

public class CH02_06_P {

    private int[] arr;
    private int arraySize;

    public CH02_06_P(int[][] array) {
        arraySize = array.length;
        arr = new int[arraySize * (arraySize + 1) / 2];
        int index = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (array[i][j] != 0) {
                    arr[index++] = array[i][j];
                }
            }
        }
    }

    public int getValue(int i, int j) {
        int index = arraySize * (i - 1) - (i - 2) * (i - 1) / 2 + j;
        return arr[index];
    }

    public static void main(String[] args) {
        int array[][] = { { 7, 8, 12, 21, 9 }, { 5, 14, 17, 6, 0 }, { 7, 23, 24, 0, 0 }, { 32, 19, 0, 0, 0 },
                { 8, 0, 0, 0, 0 } };
        CH02_06_P object = new CH02_06_P(array);
        System.out.println("-------");
        System.out.println("Upper Trangular Matrix");
        for (int i = 0; i < object.arraySize; i++) {
            for (int j = 0; j < object.arraySize; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------");
        System.out.println("Transform Matrix");
        for (int i = 0; i < object.arraySize; i++) {
            for (int j = 0; j < object.arraySize - i ; j++) {
                System.out.print(object.getValue(i + 1, j) + "\t");
            }
            for (int j = object.arraySize - i; j < object.arraySize; j++) {
                System.out.print(0 + "\t");
            }
            System.out.println();
        }
    }

}
