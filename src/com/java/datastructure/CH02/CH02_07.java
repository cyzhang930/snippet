package com.java.datastructure.CH02;

public class CH02_07 {

    private int[] arr;
    private int arraySize;

    public CH02_07() {
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public void initAndTransformWithoutZero(int[][] original) throws Exception {
        validateOriginalArray(original);

        arraySize = original.length;
        System.out.println("-------");
        System.out.println("Upper Trangular Matrix");
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(original[i][j] + "\t");
            }
            System.out.println();
        }
        int[] result = new int[arraySize * (arraySize + 1) / 2];
        int index = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (original[i][j] != 0) {
                    result[index++] = original[i][j];
                }
            }
        }
        setArr(result);
        setArraySize(arraySize);
    }

    public int getValue(int i, int j) {
        if (j > i) {
            return 0;
        }
        i = i + 1;
        int index = i * (i - 1) / 2 + j;
        return arr[index];
    }

    private void validateOriginalArray(int[][] original) throws Exception {
        if (original == null || original.length == 0) {
            throw new Exception("Empty array");
        }
        int length = original.length;
        for (int i = 0; i < length; i++) {
            int[] temp = original[i];
            if (temp == null || temp.length != length) {
                throw new Exception("Element in row " + (i + 1) + " is invalid");
            }
        }
    }
}
